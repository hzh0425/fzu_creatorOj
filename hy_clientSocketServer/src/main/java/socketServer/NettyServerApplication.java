package socketServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
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
        "socketServer.Application",
        "com.moxi.utils",
        "com.moxi.commons.config",
        "com.moxi.xo.service",
        "com.moxi.xo.util",
        "com.moxi.commons.feign",
        "com.moxi.utils.FileUtil",
})
public class NettyServerApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(NettyServerApplication.class,args);
        new serverBootstrap().start();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                //配置允许跨域访问的路径
                registry.addMapping("/**/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .allowCredentials(true)
                        .exposedHeaders("")
                        .maxAge(3600);
            }
        };
    }
}
