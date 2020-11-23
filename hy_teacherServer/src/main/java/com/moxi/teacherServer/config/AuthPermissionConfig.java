package com.moxi.teacherServer.config;

import com.moxi.teacherServer.global.SysConf;

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

        String uri=request.getRequestURI();
        //0.判断是否在白名单中
        if(SysConf.WHITE.contains(uri)){
            return true;
        }
        //1.如果是problem类型的请求,则直接放行
//        if(uri.startsWith(SysConf.RESOURCE_PROBLEM)){
//            return true;
//        }
        //2.转化为权限
        Set<String> authorities=authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toSet());
        return authorities.contains(uri);
    }
}
