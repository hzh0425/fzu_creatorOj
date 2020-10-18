package com.moxi.teacherServer.annotation.authority;

import com.moxi.commons.feign.authFeign;
import com.moxi.teacherServer.config.RedisTokenStore;
import com.moxi.utils.JsonUtils;
import com.moxi.utils.ResultUtil;
import com.moxi.utils.StringUtils;
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
import java.util.Map;

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
    @Autowired
    com.moxi.commons.feign.authFeign authFeign;
    /**
     * cut point
     */

    @Pointcut(value = "@annotation(authorityVerify)")
    public void pointcut(AuthorityVerify authorityVerify){}

    @Around(value = "pointcut(authorityVerify)")
    public Object doAround(ProceedingJoinPoint joinPoint, AuthorityVerify authorityVerify) throws Throwable {
        //1.解析token
        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attribute.getRequest();
        String token=request.getHeader(SysConf.Authorization);
        if(token==null)return ResultUtil.result(SysConf.ERROR,MessageConf.OUT_SURVIVOR_TOKEN);
        String bearerToken;
        if(token.contains(SysConf.BEARER)){
            bearerToken=token.split(SysConf.BEARER)[1];
        }else{
            return ResultUtil.result(SysConf.ERROR,MessageConf.INVALID_TOKEN);
        }

        //2.获取请求路径
        String url = request.getRequestURI();
        System.out.println("url is:"+url);
        //3.验证
        String result = authFeign.checkPermission(bearerToken, url);

        Map<String, Object> map = JsonUtils.jsonToMap(result);
        //4.结果
        String code=map.get(SysConf.CODE).toString();
        System.out.println(code);
        if(code.equals(SysConf.SUCCESS)){
            return joinPoint.proceed();
        }
        return ResultUtil.result(SysConf.ERROR,MessageConf.INVALID_AUTH);
    }

}

