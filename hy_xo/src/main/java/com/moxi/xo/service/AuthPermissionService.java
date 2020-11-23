package com.moxi.xo.service;


import com.moxi.codeBase.Interface.SuperService;
import com.moxi.xo.entity.AuthPermission;

import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
public interface AuthPermissionService extends SuperService<AuthPermission> {

    public void deleteResource(String resourceId);

    public List<AuthPermission> getPermissionTable(String classId);
}
