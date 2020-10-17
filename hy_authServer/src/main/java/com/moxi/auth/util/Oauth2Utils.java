package com.moxi.auth.util;

import com.moxi.auth.config.auth.RedisTokenStore;
import com.moxi.auth.global.SysConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/17 9:12
 */
@Component
public class Oauth2Utils {


    /**
     * 注入tokenStore
     */
    @Autowired
    RedisTokenStore redisTokenStore;


    public OAuth2AccessToken getOAuth2AccessToken(String token){
        return redisTokenStore.readAccessToken(token);
    }

    /**
     * 读取token对应的OAuth2Authentication
     * @param token
     * @return
     */
    public  OAuth2Authentication getAuthenticationInOauth2Server(String token){
       return redisTokenStore.readAuthentication(token);
    }

    /**
     * 读取GrantedAuthorities
     * @param token
     * @return
     */

    public  Collection<GrantedAuthority> getAuthorities(String token){
        OAuth2Authentication oAuth2Authentication=getAuthenticationInOauth2Server(token);
        return oAuth2Authentication.getAuthorities();
    }
}
