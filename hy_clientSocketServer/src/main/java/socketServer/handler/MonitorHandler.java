package socketServer.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import socketServer.Application.EventDispatcher;

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
    EventDispatcher eventApplication;
    /**
     * 防止无法依赖注入的初始化
     */
    public static MonitorHandler handler;

    @PostConstruct
    public void init(){
        handler=this;
    }

    /**
     * 前端传送消息
     * @param channelHandlerContext
     * @param frame
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame frame) throws Exception {
        String message=frame.text();
        if(message!=null){
            handler.eventApplication.handler(message);
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
