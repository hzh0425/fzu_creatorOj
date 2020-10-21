package com.moxi.xo.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.moxi.base.serviceImpl.SuperServiceImpl;
import com.moxi.xo.entity.AuthGroup;
import com.moxi.xo.entity.AuthPermission;
import com.moxi.xo.mapper.AuthGroupMapper;

import com.moxi.xo.service.AuthGroupService;
import com.moxi.xo.vo.PermissionGroupVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
@Service
public class AuthGroupServiceImpl extends SuperServiceImpl<AuthGroupMapper, AuthGroup> implements AuthGroupService {

    @Override
    public IPage<AuthPermission> getList(PermissionGroupVo vo) {
        return null;
    }

    @Override
    public String add(PermissionGroupVo vo) {
        return null;
    }

    @Override
    public String edit(PermissionGroupVo vo) {
        return null;
    }

    @Override
    public String delete(String groupId) {
        return null;
    }
}
