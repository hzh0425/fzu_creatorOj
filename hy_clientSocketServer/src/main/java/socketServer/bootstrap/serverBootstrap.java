package socketServer.bootstrap;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.json.JsonObjectDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import socketServer.handler.MoniterHandler;

import java.net.InetSocketAddress;

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
                    .childHandler(new ChannelInitializer<SocketChannel>() {

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
                            //自定义处理
                            pipeline.addLast("moniterHandler",new MoniterHandler());

                            /*
                             * WebSocketServerProtocolHandler核心功能是将http协议升级为ws协议,保持长连接
                             * */
                            pipeline.addLast(new WebSocketServerProtocolHandler("/ws/problem"));
                        }
                    });
            ChannelFuture future=bootstrap.bind(10000).sync();
            System.out.println("netty chatServer启动完毕");
            future.channel().closeFuture().sync();
        }finally {
            workGroup.shutdownGracefully();;
            boosGroup.shutdownGracefully();
        }
    }
}
