package socketServer.channelInitial;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import socketServer.handler.MonitorHandler;
import socketServer.handler.RegisterHandler;

import static io.netty.buffer.Unpooled.wrappedBuffer;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/29 21:37
 */
public class ServerInitailizer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline=socketChannel.pipeline();
        //基于http的编码和解码器
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new ChunkedWriteHandler());
        pipeline.addLast(new HttpObjectAggregator(1024*64));
        pipeline.addLast(new StringDecoder());
        pipeline.addLast(new StringEncoder());
        // WebSocket数据压缩
        //pipeline.addLast(new WebSocketServerCompressionHandler());

        //自定义处理
        pipeline.addLast("registerHandler",new RegisterHandler());
        // 处理websocket
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws",null,true,65526*10));

        pipeline.addLast("moniterHandler",new MonitorHandler());

    }
}
