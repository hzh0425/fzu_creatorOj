package socketServer.handler;

import com.moxi.proBuf.ProEvent;
import com.moxi.proBuf.usertest;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.springframework.stereotype.Component;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/29 15:56
 */
@Component
public class MoniterHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    private static ChannelGroup channelGroup=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame proEvent) throws Exception {
        System.out.println("get a event:"+proEvent.text());
//        usertest te= usertest.newBuilder()
//                .setName("hzh")
//                .setAge("18").build();
        Channel channel=channelHandlerContext.channel();
        channel.writeAndFlush(new TextWebSocketFrame("aqqqwerqwerqwer"));
        System.out.println("send done");
    }

}
