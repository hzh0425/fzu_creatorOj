package com.moxi.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/5 14:53
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.moxi.auth.config",
        "com.moxi.auth.server",
        "com.moxi.auth.controller",
        "com.moxi.auth.aop",
        "com.moxi.commons.config"
})
public class authApplication {
    public static void main(String[] args) {
        SpringApplication.run(authApplication.class,args);
    }
}
