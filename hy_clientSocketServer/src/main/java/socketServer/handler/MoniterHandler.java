package socketServer.handler;

import com.moxi.proBuf.ProEvent;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.stereotype.Component;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/29 15:56
 */
@Component
public class MoniterHandler extends SimpleChannelInboundHandler<ProEvent> {
    private static ChannelGroup channelGroup=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ProEvent proEvent) throws Exception {
        System.out.println("get a event:"+proEvent);
        switch (proEvent.getEventType()){
            case "submit":{
                System.out.println("get a submit");
                System.out.println(proEvent.getSubmit());
            }
        }
    }


}
