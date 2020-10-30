package socketServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import socketServer.bootstrap.serverBootstrap;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/8 21:28
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "socketServer.config",
        "socketServer.bootstrap",
        "socketServer.handler",
        "socketServer.restApi",
        "socketServer.message",
        "socketServer.util",
        "socketServer.Application"
})
public class NettyServerApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(NettyServerApplication.class,args);
        new serverBootstrap().start();
    }
}
