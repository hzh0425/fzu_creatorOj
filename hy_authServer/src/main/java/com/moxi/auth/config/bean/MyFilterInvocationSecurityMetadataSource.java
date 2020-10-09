package com.moxi.auth.config.bean;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 根据url获取 url需要访问的权限
 * @author hzh
 * @version 1.0
 * @date 2020/10/8 0:32
 */
@Component
public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    /**
     * getAttributes 方法确定一个请求需要哪些角色
     * @param object 是FilterInvocation对象，可以获取当前请求的Url
     * @return Collection<ConfigAttribute> 当前请求Url所需要的角色
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String[] urls=((FilterInvocation) object).getRequestUrl().split("\\?");
        String requestUrl="";
        if(urls.length>0){
            requestUrl=urls[0];
        }else{
            System.out.println("无权限");
            requestUrl="not permission";
        }
        System.out.println("the request url is:"+requestUrl);
        return SecurityConfig.createList(requestUrl);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    public static void main(String[] args) {
        String[] url="/api/info?token=awer".split("\\?");
        System.out.println(url[0]);
    }
}
