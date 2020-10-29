package socketServer.channelInitial;

import com.moxi.proBuf.ProEvent;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.json.JsonObjectDecoder;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.stream.ChunkedWriteHandler;
import socketServer.handler.MoniterHandler;

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
        pipeline.addLast(new JsonObjectDecoder());
        /*
         * 说明:
         * 1 http数据在传输过程中是分段的,HttpObjectAggregator可以将段聚合起来
         * */
        pipeline.addLast(new HttpObjectAggregator(1024*64));
        pipeline.addLast(new JsonObjectDecoder());

        /**
         * protobuf
         */
        pipeline.addLast(new ProtobufVarint32FrameDecoder());
        pipeline.addLast(new ProtobufDecoder(ProEvent.getDefaultInstance()));
        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
        pipeline.addLast(new ProtobufEncoder());

        //自定义处理
        pipeline.addLast("moniterHandler",new MoniterHandler());

        /*
         * WebSocketServerProtocolHandler核心功能是将http协议升级为ws协议,保持长连接
         * */
        //pipeline.addLast(new WebSocketServerProtocolHandler("/ws/problem"));
    }
}
