package com.moxi.teacherServer.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/19 20:21
 * oauth2动态权限扩展
 *
 */
@Component("authPermissionConfig")
public class AuthPermissionConfig {
    public boolean canAccess(HttpServletRequest request, Authentication authentication){
        //1.转化为权限
        Set<String> authorities=authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());
        String uri=request.getRequestURI();
        System.out.println("the uri is:"+uri);
        return authorities.contains(uri);
    }
}
