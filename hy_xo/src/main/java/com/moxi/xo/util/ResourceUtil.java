package com.moxi.xo.util;

import com.moxi.utils.ServerInfo.Sys;
import com.moxi.xo.entity.AuthPermission;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.service.AuthPermissionService;
import com.moxi.xo.vo.ResourceReturningVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/18 9:18
 * 资源工具
 */
@Component
public class ResourceUtil {
    @Autowired
    private   AuthPermissionService permissionService;

    @Async
    public   void buildPermissionAfterAddResource(ResourceReturningVo vo){
        List<AuthPermission> list=new ArrayList<>();
        List<String> operationType= SysConf.OPERATIONS;
        List<String> operand=null;
        //1.选择资源的对象类型
        switch (vo.getResourceType()){
            case SysConf.RESOURCE_CLASS:{
                operand= SysConf.CLASS_OPERAND;
                break;
            }
        }
        //2.创建资源
        for (int i = 0; i <operand.size() ; i++) {
            for (int j = 0; j <operationType.size() ; j++) {
                AuthPermission authPermission= AuthPermission.builder()
                        .resourceType(vo.getResourceType())
                        .resourceId(vo.getResourceId())
                        .ownerId(vo.getOwnerId())
                        .operationType(operationType.get(j))
                        .operand(operand.get(i))
                        .createDate(new Date())
                        .build();
                list.add(authPermission);
            }
        }
        permissionService.saveBatch(list);
    }
}
