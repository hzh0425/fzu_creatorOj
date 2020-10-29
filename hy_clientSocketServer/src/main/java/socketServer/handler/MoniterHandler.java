package socketServer.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
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
public class MoniterHandler extends ChannelInboundHandlerAdapter {
    private static ChannelGroup channelGroup=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("get connect:"+ctx.channel().remoteAddress());
        channelGroup.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("remove connect:"+ctx.channel().remoteAddress());
        channelGroup.remove(ctx.channel());
    }


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("server receive a message: "+msg);
    }
}
