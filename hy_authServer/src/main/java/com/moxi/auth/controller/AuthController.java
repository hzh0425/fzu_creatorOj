package com.moxi.auth.controller;

import com.moxi.auth.entity.CommonResult;
import com.moxi.auth.entity.Oauth2TokenVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/17 0:29
 * 自定义oauth2 登录令牌
 */
@RestController
@RequestMapping("/oauth")
public class AuthController {

    //将oauth2框架的tokenEndpoint注入
    @Autowired
    private TokenEndpoint tokenEndpoint;

    @PostMapping(value ="/token")
    public CommonResult<Oauth2TokenVo> postAccessToken(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken oAuth2AccessToken=tokenEndpoint.postAccessToken(principal,parameters).getBody();
        Map<String,Object> map=new HashMap<>(oAuth2AccessToken.getAdditionalInformation());
        Oauth2TokenVo vo=Oauth2TokenVo.builder()
                .token(oAuth2AccessToken.getValue())
                .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
                .expiresIn(oAuth2AccessToken.getExpiresIn())
                .tokenHead("bearer")
                .userId(map.get("userId").toString())
                .build();
        CommonResult<Oauth2TokenVo> result=new CommonResult<>(300,"成功",vo);
        return result;
    }

}
