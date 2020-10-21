package com.moxi.xo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.moxi.base.serviceImpl.SuperServiceImpl;
import com.moxi.utils.ResultUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.entity.AuthGroupPermission;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.mapper.AuthGroupPermissionMapper;
import com.moxi.xo.service.AuthGroupPermissionService;
import com.moxi.xo.vo.PermissionGroupVo;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
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
public class AuthGroupPermissionServiceImpl extends SuperServiceImpl<AuthGroupPermissionMapper, AuthGroupPermission> implements AuthGroupPermissionService {
    @Autowired
    AuthGroupPermissionService authGroupPermissionService;
    @Resource
    AuthGroupPermissionMapper authGroupPermissionMapper;

    @Override
    public String add(PermissionGroupVo vo) {
        if(StringUtils.isNotEmpty(vo.getPermissionIds())){
            List<AuthGroupPermission> authGroupPermissionList= Arrays.stream(vo.getPermissionIds().split(SysConf.FILE_SEGMENTATION))
                                                    .map(x->{
                                                        return new AuthGroupPermission(vo.getUid(),x);
                                                    }).collect(Collectors.toList());
            authGroupPermissionService.saveBatch(authGroupPermissionList);
        }
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String delete(PermissionGroupVo vo) {
        if(StringUtils.isNotEmpty(vo.getPermissionIds())){
            List<String> permissionIds= Arrays.stream(vo.getPermissionIds().split(SysConf.FILE_SEGMENTATION)).collect(Collectors.toList());
            QueryWrapper<AuthGroupPermission> wrapper=new QueryWrapper<AuthGroupPermission>(){{
                in(SysConf.PID,permissionIds);
                eq(SysConf.RID,vo.getUid());
            }};
            authGroupPermissionMapper.delete(wrapper);
        }
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.DELETE_SUCCESS);
    }
}
