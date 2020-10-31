package socketServer.handler;

import com.moxi.xo.global.SysConf;
import com.netflix.client.http.HttpRequest;
import com.sun.deploy.net.proxy.pac.PACFunctions;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import socketServer.Application.EventDispatcher;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/31 16:09
 */
public class RegisterHandler extends SimpleChannelInboundHandler {

    @Autowired
    EventDispatcher eventDispatcher;

    private static RegisterHandler handler;
    @PostConstruct
    public void init(){
        handler=this;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("receive a http ");
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
                        String[] paramsArray =uriArrays[1].split("&");
                        if(paramsArray != null && paramsArray.length>0){
                            doRegister(ctx.channel(),paramsArray);
                        }
                    }
                }
            }
        }
    }

    public void doRegister(Channel channel, String[] paramsArray){
        for(String s:paramsArray) System.out.println(s);
        Map<String,String> paramsMap=new HashMap<>();
        if(paramsArray.length==3){
            //传递了 userId,userType,examId
            paramsMap.put(SysConf.USER_ID,  paramsArray[0]);
            paramsMap.put(SysConf.USER_TYPE,paramsArray[1]);
            paramsMap.put(SysConf.EXAM_ID,  paramsArray[2]);
        }else if(paramsArray.length==1){
            //传递了 userId
            paramsMap.put(SysConf.USER_ID,paramsArray[0]);
        }else if(paramsArray.length==0){
            System.out.println("no params");
        }
        handler.eventDispatcher.register(channel,paramsMap);
    }
}
