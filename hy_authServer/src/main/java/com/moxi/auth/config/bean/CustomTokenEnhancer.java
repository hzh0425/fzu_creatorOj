package com.moxi.auth.config.bean;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/17 0:51
 */
@Component
public class CustomTokenEnhancer implements TokenEnhancer {
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        MySecurityUser user=(MySecurityUser) oAuth2Authentication.getPrincipal();
        Map<String,Object> map=new HashedMap();
        map.put("userId",user.getUserId());

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(map);
        return oAuth2AccessToken;
    }
}
