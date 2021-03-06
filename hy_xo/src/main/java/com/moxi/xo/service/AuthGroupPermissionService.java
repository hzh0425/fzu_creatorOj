package com.moxi.xo.service;


import com.moxi.codeBase.Interface.SuperService;
import com.moxi.xo.entity.AuthGroupPermission;
import com.moxi.xo.vo.PermissionGroupVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
public interface AuthGroupPermissionService extends SuperService<AuthGroupPermission> {

    public String add(String groupId,String permissionIds);

    public String delete(String groupID,String permissionIds);
}
