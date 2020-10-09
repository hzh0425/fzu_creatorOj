package com.moxi.teacherServer.restApi;

import com.moxi.xo.entity.AuthPermission;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/8 21:58
 */
@RestController
@RequestMapping("/teacher")
public class test {
    @GetMapping("/test1")
    @PreAuthorize("hasAuthority('query')")
    public String test(){
        AuthPermission permission=new AuthPermission();
        permission.setCreateDate(new Date());
        permission.setMethod("Get");
        permission.setOwnerId("qwoeijroqiwjerioqwer");
        permission.setUrl("/teacher/test1");
        permission.setValid(1);
        permission.insert();

        permission.setUrl("/teacher/test2");
        permission.insert();
        permission.setUrl("/teacher/test3");
        permission.insert();
        return "success2";
    }

    @GetMapping("/test2")
    @PreAuthorize("hasAuthority('query2')")
    public String test2(){
        return "succesqrq234";
    }
}
