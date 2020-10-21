package com.moxi.xo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.moxi.base.serviceImpl.SuperServiceImpl;
import com.moxi.xo.entity.AuthPermission;
import com.moxi.xo.entity.AuthGroupPermission;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.mapper.AuthPermissionMapper;
import com.moxi.xo.mapper.AuthGroupPermissionMapper;
import com.moxi.xo.service.AuthPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
@Service
public class AuthPermissionServiceImpl extends SuperServiceImpl<AuthPermissionMapper, AuthPermission> implements AuthPermissionService {

    @Autowired
    AuthPermissionService authPermissionService;
    @Resource
    AuthPermissionMapper authPermissionMapper;
    @Resource
    AuthGroupPermissionMapper authRolePermissionMapper;

    /**
     * 删除相关权限
     * @param resourceId
     */
    @Async
    @Override
    public void deleteResource(String resourceId) {
        //根据resourceId查询出permissionId和permissionId的uid
        QueryWrapper<AuthPermission> permissionQueryWrapper=new QueryWrapper<AuthPermission>(){{
            eq(SysConf.RESOURCE_ID,resourceId);
            select(SysConf.UID,SysConf.RESOURCE_ID);
        }};
        List<AuthPermission> permissionList=authPermissionService.list(permissionQueryWrapper);
        List<String> PermissionIds=permissionList
                                    .stream()
                                    .map(AuthPermission::getResourceId)
                                    .collect(Collectors.toList());
        List<String> PermissionUIds=permissionList
                                    .stream()
                                    .map(AuthPermission::getUid)
                                    .collect(Collectors.toList());
        //批量删除权限
        authPermissionMapper.deleteBatchIds(PermissionUIds);
        //批量删除权限-角色中间表
        QueryWrapper<AuthGroupPermission> rolePermissionQueryWrapper=new QueryWrapper<AuthGroupPermission>(){{
            in(SysConf.PID,PermissionIds);
        }};
        authRolePermissionMapper.delete(rolePermissionQueryWrapper);

    }
}
