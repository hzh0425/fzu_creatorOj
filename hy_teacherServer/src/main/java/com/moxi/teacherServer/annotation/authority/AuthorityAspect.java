package com.moxi.teacherServer.annotation.authority;

import com.moxi.teacherServer.config.RedisTokenStore;
import com.moxi.utils.ResultUtil;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.global.SysConf;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/7 17:27
 *
 * 该aop主要用于解决例如 /user/{id}/delete 之类的权限验证
 */
@Aspect
@Component
public class AuthorityAspect {
    @Autowired
    RedisTokenStore tokenStore;
    /**
     * cut point
     */

    @Pointcut(value = "@annotation(authorityVerify)")
    public void pointcut(AuthorityVerify authorityVerify){}

    @Around(value = "pointcut(authorityVerify)")
    public Object doAround(ProceedingJoinPoint joinPoint, AuthorityVerify authorityVerify) throws Throwable {
        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attribute.getRequest();

        String token=request.getHeader("Authorization");
        if(token==null)return ResultUtil.result(SysConf.ERROR,MessageConf.OUT_SURVIVOR_TOKEN);
        String bearerToken=token.split("bearer")[1];
        if(bearerToken==null)return ResultUtil.result(SysConf.ERROR,MessageConf.INVALID_TOKEN);
        //获取请求路径
        String url = request.getRequestURI();
        OAuth2Authentication auth2Authentication= tokenStore.readAuthentication(bearerToken);
        if(auth2Authentication==null){
            return ResultUtil.result(SysConf.ERROR, MessageConf.LOGIN_TIMEOUT);
        }
        Collection<? extends GrantedAuthority> authorities = auth2Authentication.getAuthorities();
        for(GrantedAuthority authority:authorities){
            String per = authority.getAuthority();
            if(per.equals(url)){
                return joinPoint.proceed();
            }
        }
        return ResultUtil.result(SysConf.ERROR,MessageConf.INVALID_AUTH);
    }

}

