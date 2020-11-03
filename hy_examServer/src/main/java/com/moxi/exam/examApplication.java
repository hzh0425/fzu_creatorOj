package com.moxi.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/11/3 20:03
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.moxi.exam.restApi",
        "com.moxi.exam.config",
        "com.moxi.exam.factory",
        "com.moxi.utils",
        "com.moxi.commons.config",
        "com.moxi.xo.service",
        "com.moxi.xo.util",
        "com.moxi.commons.feign",
        "com.moxi.utils.FileUtil",
        "com.moxi.exam.Application"
})
public class examApplication {
    public static void main(String[] args) {
        SpringApplication.run(examApplication.class,args);
    }
}
