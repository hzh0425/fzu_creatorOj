package com.moxi.teacherServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/8 21:53
 */
@SpringBootApplication
@EnableOpenApi
@ComponentScan(basePackages = {
        "com.moxi.teacherServer.config",
        "com.moxi.teacherServer.restApi",
        "com.moxi.commons.config",//公共配置
        "com.moxi.xo.service",
        "com.moxi.commons.feign",
        "com.moxi.utils.FileUtil"
})
public class teacherServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(teacherServerApplication.class,args);
    }

    /**
     * 跨域配置
     * @return
     */
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
