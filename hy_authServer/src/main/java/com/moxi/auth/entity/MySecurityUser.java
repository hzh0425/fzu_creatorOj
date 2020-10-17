package com.moxi.auth.entity;

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

    public int userType;

    public MySecurityUser(String userId,String userDesc,int userType,String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userId=userId;
        this.userDesc=userDesc;
        this.userType=userType;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public String getUserId() {
        return userId;
    }

    public int getUserType() {
        return userType;
    }
}
