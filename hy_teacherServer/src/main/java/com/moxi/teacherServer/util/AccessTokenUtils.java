package com.moxi.teacherServer.util;

import com.moxi.teacherServer.config.RedisTokenStore;
import com.moxi.utils.ServerInfo.Sys;
import com.moxi.xo.global.SysConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/21 0:50
 */
@Component
public class AccessTokenUtils {
    @Autowired
    RedisTokenStore  tokenStore;
    public String getUserId(HttpServletRequest request){
        String bearerToken=request.getHeader(SysConf.Authorization);
        if(bearerToken!=null&&bearerToken.startsWith(SysConf.BEARER)){
            String token=bearerToken.split(SysConf.BEARER)[1];
            OAuth2AccessToken oAuth2AccessToken=tokenStore.readAccessToken(token);
            if(oAuth2AccessToken!=null){
                if(oAuth2AccessToken.getAdditionalInformation().get(SysConf.USER_ID)!=null){
                    return oAuth2AccessToken.getAdditionalInformation().get(SysConf.USER_ID).toString();
                }
            }
        }
        return null;
    }
}
