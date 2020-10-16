package com.moxi.auth.config.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/17 0:57
 */

public class MySecurityUser extends User {

    public  String userId;

    public String userDesc;

    public MySecurityUser(String userId,String userDesc,String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        System.out.println("get a userId"+userId);
        this.userId=userId;
        this.userDesc=userDesc;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public String getUserId() {
        return userId;
    }
}
