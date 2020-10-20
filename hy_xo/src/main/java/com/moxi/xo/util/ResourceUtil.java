package com.moxi.xo.util;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.moxi.utils.ServerInfo.Sys;
import com.moxi.xo.entity.AuthPermission;
import com.moxi.xo.entity.RequestTemplate;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.service.AuthPermissionService;
import com.moxi.xo.service.RequestTemplateService;
import com.moxi.xo.vo.ResourceReturningVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    RequestTemplateService requestTemplateService;

    /**
     *
     * @param vo
     * resourceId 资源类型
     */
    @Async
    public void buildPermissionAfterAddResource(ResourceReturningVo vo,int resourceId){
        //1.查询数据库中的请求模板
        QueryWrapper<RequestTemplate> wrapper=new QueryWrapper<RequestTemplate>(){{
            eq(SysConf.RESOURCE_ID,resourceId);
        }};
        List<RequestTemplate> requestTemplateList = requestTemplateService.list(wrapper);
        //2.根据模板,构建权限表
        List<AuthPermission> collect = requestTemplateList.stream().map(x -> {
            System.out.println(x);
            return AuthPermission.builder()
                    .resourceType(vo.getResourceType())
                    .resourceId(vo.getResourceId())
                    .ownerId(vo.getOwnerId())
                    .operationType(x.getOperationType())
                    .operand(x.getOperand())
                    .createDate(new Date())
                    .build();
        }).collect(Collectors.toList());
        permissionService.saveBatch(collect);
    }
}
