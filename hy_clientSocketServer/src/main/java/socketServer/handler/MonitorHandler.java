package socketServer.handler;

import com.moxi.utils.StringUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import socketServer.Application.SubmitApplication;
import socketServer.Interface.ApplicationService;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/29 15:56
 */
@Component
public class MonitorHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {


    /**
     * 依赖注入
     */
    @Autowired
    SubmitApplication submitApplication;


    private  List<ApplicationService> chains;
    /**
     * 防止无法依赖注入的初始化,并初始化责任链
     */
    public static MonitorHandler handler;

    @PostConstruct
    public void init(){
        handler=this;
        handler.chains=new ArrayList<ApplicationService>(){{
            add(handler.submitApplication);
        }};
    }

    /**
     * 前端传送消息,传递至application责任链
     * @param channelHandlerContext
     * @param frame
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame frame) throws Exception {
        String message=frame.text();
        if(StringUtils.isNotEmpty(message)){
            for(ApplicationService application:handler.chains){
                if(application.supportEvent(message)){
                    application.handleEvent(message);
                    break;
                }else{
                    System.out.println("it is no suport");
                }
            }
        }
    }

    /**
     * 连接请求
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

    }
}
