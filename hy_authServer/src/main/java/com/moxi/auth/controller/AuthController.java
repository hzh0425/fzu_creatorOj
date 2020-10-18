package com.moxi.auth.controller;


import com.moxi.auth.entity.Oauth2TokenVo;
import com.moxi.auth.global.SysConf;
import com.moxi.auth.util.Oauth2Utils;
import com.moxi.base.enums.EStatus;
import com.moxi.utils.ResultUtil;

import com.moxi.xo.entity.AuthUser;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.service.AuthStudentService;
import com.moxi.xo.service.AuthUserAdminService;
import com.moxi.xo.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.AuthorizationEndpoint;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;
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
    @Autowired
    private Oauth2Utils oauth2Utils;


    /**
     * 重写token接口,返回自定义的信息
     * @param principal
     * @param parameters
     * @return
     * @throws HttpRequestMethodNotSupportedException
     */
    @PostMapping(value ="/token")
    public String postAccessToken(Principal principal, @RequestParam Map<String, String> parameters) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken oAuth2AccessToken=tokenEndpoint.postAccessToken(principal,parameters).getBody();
        Map<String,Object> map=new HashMap<>(oAuth2AccessToken.getAdditionalInformation());
        Oauth2TokenVo vo=Oauth2TokenVo.builder()
                .token(oAuth2AccessToken.getValue())
                .refreshToken(oAuth2AccessToken.getRefreshToken().getValue())
                .expiresIn(oAuth2AccessToken.getExpiresIn())
                .tokenHead(SysConf.BEARER)
                .userId(map.get(SysConf.USER_ID).toString())
                .build();
        return ResultUtil.result(SysConf.SUCCESS,vo);
    }


    /**
     * 判断用户是否具有某个资源的权限
     */
    @GetMapping(value = "/checkPermission")
    public String checkPermission(@RequestParam("token")String token,@RequestParam("url") String url){
        System.out.println(token);
        Collection<GrantedAuthority> authorities=oauth2Utils.getAuthorities(token);
        Boolean flag=false;
        for(GrantedAuthority authority:authorities){
            String per = authority.getAuthority();
            if(per.equals(url)){
                flag=true;break;
            }
        }
        if(flag){
            return ResultUtil.result(SysConf.SUCCESS, MessageConf.HAVE_AUTH);
        }else{
            return ResultUtil.result(SysConf.ERROR,MessageConf.INVALID_AUTH);
        }
    }

    /**
     * 获取教师的信息
     */



    /**
     * 用户注册
     */


}
