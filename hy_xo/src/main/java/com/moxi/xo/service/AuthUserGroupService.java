package com.moxi.xo.service;


import com.moxi.codeBase.Interface.SuperService;
import com.moxi.xo.entity.AuthUserGroup;
import com.moxi.xo.vo.PermissionGroupVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
public interface AuthUserGroupService extends SuperService<AuthUserGroup> {

    public String add(String groupIds,String memberIds);

    public String delete(String groupIds,String memberIds);
}
