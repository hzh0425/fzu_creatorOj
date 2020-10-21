package com.moxi.xo.service;

import com.moxi.base.service.SuperService;
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

    public String add(PermissionGroupVo vo);

    public String delete(PermissionGroupVo vo);
}
