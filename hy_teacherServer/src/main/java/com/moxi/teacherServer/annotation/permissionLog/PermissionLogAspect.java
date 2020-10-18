package com.moxi.teacherServer.annotation.permissionLog;

import com.alibaba.fastjson.JSON;
import com.moxi.base.enums.EStatus;
import com.moxi.utils.JsonUtils;
import com.moxi.xo.entity.AuthPermission;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.vo.ResourceReturningVo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
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
        //1.解析返回体
        ServletRequestAttributes attribute = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attribute.getRequest();
        Map result = JsonUtils.jsonToMap(keys.toString());
        ResourceReturningVo vo=  JSON.parseObject(result.get(SysConf.DATA).toString(), ResourceReturningVo.class);

        //2.获取指定数据
        String[] operand = permissionLogVerify.operand();
        String[] operationType=permissionLogVerify.operationType();

        //3.创建permission实体
        for (int i = 0; i <operand.length ; i++) {
            for (int j = 0; j <operationType.length ; j++) {
                AuthPermission authPermission= AuthPermission.builder()
                        .resourceType(permissionLogVerify.resourceType())
                        .resourceId(vo.getResourceId())
                        .ownerId(vo.getOwnerId())
                        .operation_type(operationType[j])
                        .operand(operand[i])
                        .createDate(new Date())
                        .build();
                authPermission.insert();
            }
        }
    }

}
