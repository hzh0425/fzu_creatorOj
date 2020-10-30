package socketServer.channelInitial;

import com.moxi.proBuf.ProEvent;
import com.moxi.proBuf.ProTest;
import com.moxi.proBuf.usertest;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.json.JsonObjectDecoder;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
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
        pipeline.addLast(new HttpObjectAggregator(1024*64));
        pipeline.addLast(new StringDecoder());
        pipeline.addLast(new StringEncoder());


        /*
         * WebSocketServerProtocolHandler核心功能是将http协议升级为ws协议,保持长连接
         * */
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        /**
         * protobuf
         */
//        //解码器，通过Google Protocol Buffers序列化框架动态的切割接收到的ByteBuf
//        pipeline.addLast(new ProtobufVarint32FrameDecoder());
//        //服务器端接收的是客户端RequestUser对象，所以这边将接收对象进行解码生产实列
//        pipeline.addLast(new ProtobufDecoder(ProTest.getDefaultInstance()));
//        //Google Protocol Buffers编码器
//        pipeline.addLast(new ProtobufVarint32LengthFieldPrepender());
//        //Google Protocol Buffers编码器
//        pipeline.addLast(new ProtobufEncoder());

        //自定义处理
        pipeline.addLast("moniterHandler",new MoniterHandler());

    }
}
