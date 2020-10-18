package com.moxi.teacherServer.annotation.permissionLog;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.moxi.base.enums.EStatus;
import com.moxi.utils.JsonUtils;
import com.moxi.xo.entity.AuthPermission;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.service.AuthPermissionService;
import com.moxi.xo.vo.ResourceReturningVo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/16 0:01
 * 该aop用于增加资源权限,执行在addxxxx 方法之后
 */
@Aspect
@Component
public class PermissionLogAspect {
    @Autowired
    AuthPermissionService permissionService;
    @Pointcut(value = "@annotation(permissionLogVerify)")
    public void pointcut(permissionLogVerify permissionLogVerify){}

    @AfterReturning(value = "pointcut(permissionLogVerify)",returning = "keys", argNames = "joinPoint,keys,permissionLogVerify")
    public void afReturn(JoinPoint joinPoint,String  keys,permissionLogVerify permissionLogVerify){
        //1.解析返回体
        Map result = JsonUtils.jsonToMap(keys);


        if(result.get(SysConf.CODE).toString().equals(SysConf.ERROR)){
            return;
        }
        ResourceReturningVo vo=JSON.parseObject(result.get(SysConf.DATA).toString(),ResourceReturningVo.class);


        //2.创建permission资源
        buildPermission(
                permissionLogVerify.operand(),
                permissionLogVerify.operationType(),
                permissionLogVerify.resourceType(),
                vo.getResourceId(),
                vo.getOwnerId());
    }

    @Async
    public void buildPermission(String [] operand,String []operationType,String type,String resourceId,String ownerId){
        List<AuthPermission> list=new ArrayList<>();
        for (int i = 0; i <operand.length ; i++) {
            for (int j = 0; j <operationType.length ; j++) {
                AuthPermission authPermission= AuthPermission.builder()
                        .resourceType(type)
                        .resourceId(resourceId)
                        .ownerId(ownerId)
                        .operationType(operationType[j])
                        .operand(operand[i])
                        .createDate(new Date())
                        .build();
                list.add(authPermission);
            }
        }
        permissionService.saveBatch(list);
    }

}
