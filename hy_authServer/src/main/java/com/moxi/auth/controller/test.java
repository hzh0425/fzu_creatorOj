package com.moxi.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/12 17:13
 */
@RestController
@RequestMapping("/info")
public class test {
    @GetMapping("/test")
    public String test1(){
        return "success";
    }
}
