package com.moxi.judgerGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/25 15:37
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.moxi.judgerGateway.kafka",
        "com.moxi.judgerGateway.web"
})
public class judgerGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(judgerGatewayApplication.class,args);
    }
}
