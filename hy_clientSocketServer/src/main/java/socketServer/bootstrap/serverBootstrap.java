package socketServer.bootstrap;
import com.moxi.proBuf.ProEvent;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.json.JsonObjectDecoder;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.stream.ChunkedWriteHandler;
import socketServer.channelInitial.ServerInitailizer;
import socketServer.handler.MoniterHandler;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/29 15:46
 */

public class serverBootstrap {
    public void start () throws Exception {
        EventLoopGroup workGroup= new NioEventLoopGroup();
        EventLoopGroup boosGroup=new NioEventLoopGroup();
        try{
            ServerBootstrap bootstrap=new ServerBootstrap();
            bootstrap.group(boosGroup,workGroup)
                    .channel(NioServerSocketChannel.class)//使用NioServerSocketChannel,作为服务器的通道实现
                    .option(ChannelOption.SO_BACKLOG,128)//设置线程队列的连接个数
                    .childOption(ChannelOption.SO_KEEPALIVE,true)//设置保持活动连接状态
                    .childHandler(new ServerInitailizer()); //pipeline inbound outbound 初始化
            ChannelFuture future=bootstrap.bind(10000).sync();
            System.out.println("netty chatServer启动完毕");
            future.channel().closeFuture().sync();
        }finally {
            workGroup.shutdownGracefully();;
            boosGroup.shutdownGracefully();
        }
    }
}
