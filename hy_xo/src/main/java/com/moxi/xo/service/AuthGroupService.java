package com.moxi.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.moxi.base.service.SuperService;
import com.moxi.xo.entity.AuthGroup;
import com.moxi.xo.entity.AuthPermission;
import com.moxi.xo.vo.PermissionGroupVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
public interface AuthGroupService extends SuperService<AuthGroup> {

    public IPage<AuthPermission> getList(PermissionGroupVo vo);

    public String add(PermissionGroupVo vo);

    public  String edit(PermissionGroupVo vo);

    public String delete(String groupId);
}
