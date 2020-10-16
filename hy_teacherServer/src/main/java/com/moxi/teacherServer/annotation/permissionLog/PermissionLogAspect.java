package com.moxi.teacherServer.annotation.permissionLog;

import com.alibaba.fastjson.JSON;
import com.moxi.base.enums.EStatus;
import com.moxi.xo.entity.AuthPermission;
import com.moxi.xo.vo.ResourceReturningVo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/16 0:01
 * 该aop用于增加资源权限,执行在addxxxx 方法之后
 */
@Aspect
@Component
public class PermissionLogAspect {
    @Pointcut(value = "@annotation(permissionLogVerify)")
    public void pointcut(permissionLogVerify permissionLogVerify){}

    @AfterReturning(value = "pointcut(permissionLogVerify)",returning = "keys", argNames = "joinPoint,keys,permissionLogVerify")
    public void afReturn(JoinPoint joinPoint,Object keys,permissionLogVerify permissionLogVerify){
        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = attribute.getRequest();


        System.out.println(keys);

        Map result = (Map) JSON.parse(keys.toString());

        ResourceReturningVo vo=  JSON.parseObject(result.get("data").toString(), ResourceReturningVo.class);

        AuthPermission permission=new AuthPermission(vo.getPermissionUrl(),request.getMethod(),vo.getOwnerId(), EStatus.ENABLE,new Date(),new Date());

        System.out.println(permission);
        permission.insert();
    }

}
