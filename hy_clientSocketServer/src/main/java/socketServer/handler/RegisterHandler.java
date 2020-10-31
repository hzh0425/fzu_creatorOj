package socketServer.handler;

import com.moxi.utils.StringUtils;
import com.moxi.xo.global.SysConf;
import com.netflix.client.http.HttpRequest;
import com.sun.deploy.net.proxy.pac.PACFunctions;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import socketServer.Application.EventDispatcher;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/31 16:09
 */
@Component
public class RegisterHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    @Autowired
    EventDispatcher eventDispatcher;

    public  static RegisterHandler handler;

    @PostConstruct
    public void init(){
        handler=this;
    }

    /**
     * 首次连接是FullHttpRequest，处理参数
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public  void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof FullHttpRequest){
            FullHttpRequest request= (FullHttpRequest) msg;
            String uri= request.uri();
            String origin = request.headers().get("Origin");
            if(origin == null){
                 ctx.close();
            }else{
                if(uri != null && uri.contains("/ws") && uri.contains("?")){
                    String[] uriArrays = uri.split("\\?");
                    if(uriArrays != null && uriArrays.length>1){
                        String paramUri= uriArrays[1];
                        Map<String,String> paramMap= getParamMap(paramUri);
                        doRegister(ctx.channel(),paramMap);
                    }
                }
            }
            request.setUri("/ws");
        }
        //fire下一个handler
        ctx.fireChannelRead(msg);
    }

    /**
     * 注册
     * @param channel
     * @param paramMap
     */
    public void doRegister(Channel channel, Map<String,String> paramMap){
        handler.eventDispatcher.register(channel , paramMap);
    }

    /**
     * 获取map参数表
     * @param paramUri
     * @return
     */
    public Map<String,String> getParamMap(String paramUri){
        Map<String,String> paramsMap= new HashMap<>();
        if(StringUtils.isNotEmpty(paramUri)){
            String[] paramsArray= paramUri.split(SysConf.FILE_COLLATION);
            if(paramsArray.length > 0){
                Arrays.stream(paramsArray).forEach(str->{
                    String [] temp= str.split(SysConf.FILE_EQUAL);
                    if(temp.length==2){
                        paramsMap.put(temp[0],temp[1]);
                    }
                });
            }
        }
        return paramsMap;
    }


    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
    }
}
