package com.moxi.judge;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/25 23:21
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.moxi.judge.core",
        "com.moxi.judge.message",
        "com.moxi.judge.model",
        "com.moxi.judge.util",
        "com.moxi.judge.Application",
})
@MapperScan(basePackages = {
        "com.moxi.judge.mapper"
})
public class judgeApplication {
    public static void main(String[] args) {
        SpringApplication.run(judgeApplication.class,args);
    }
}
