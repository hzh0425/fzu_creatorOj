package com.moxi.auth.controller;

import com.moxi.auth.aop.authority.AuthorityVerify;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 〈会员Controller〉
 * @author wangmx
 * @create 2018/12/13
 * @since 1.0.0
 */
@RestController
@RequestMapping("/api")
public class MemberController {

    //该注解需要先开启在security中配置EnableGlobalMethodSecurity
    @PreAuthorize("hasAuthority('test')")
    @GetMapping("/admin/hello/{id}")
    public String admin(@PathVariable int id) {
        return "hello admin:"+id;
    }



    @GetMapping("/user/info")
    public String user() {
        return "user is:asldkfjalsdf";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

}
