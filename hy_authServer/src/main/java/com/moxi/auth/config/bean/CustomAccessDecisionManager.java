package com.moxi.auth.config.bean;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/8 0:41
 */
@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {
    /**
     *判断登录的用户是否具有请求Url所需要的角色信息，如果没有，就抛出AccessDeniedException异常
     * @param auth 包含当前登录用户的信息
     * @param object 获取当前请求对象
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication auth, Object object, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        for(ConfigAttribute attribute:collection){
            if(attribute.getAttribute().equals("login")){
                return;
            }
            for(GrantedAuthority authority:authorities){
                if(authority.getAuthority().equals(attribute.getAttribute())){
                    System.out.println("您具有以下访问权限:"+authority.getAuthority());
                    return;
                }
            }
        }
        throw  new AccessDeniedException("权限不足,拒绝访问");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
