package com.moxi.auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/8 0:59
 */
@RequestMapping("/info")
@RestController
public class infoController {
    @GetMapping("/test1")
    @PreAuthorize("hasAuthority('/admin/test1')")
    public String test1(){
      return "success";
  }

    @GetMapping("/test2")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String test2(){
        return "success";
    }


    @GetMapping("/test3")
    @PreAuthorize("hasAuthority('ADMIN2')")
    public String test3(){
        return "success";
    }
}
