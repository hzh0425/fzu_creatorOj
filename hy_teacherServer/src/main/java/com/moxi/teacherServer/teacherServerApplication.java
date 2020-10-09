package com.moxi.teacherServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/8 21:53
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.moxi.teacherServer.config",
        "com.moxi.teacherServer.restApi",
        "com.moxi.commons.config"//公共配置
})
public class teacherServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(teacherServerApplication.class,args);
    }
}
