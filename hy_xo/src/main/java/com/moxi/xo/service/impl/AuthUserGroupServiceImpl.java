package com.moxi.xo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.moxi.base.serviceImpl.SuperServiceImpl;
import com.moxi.utils.ResultUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.entity.AuthUserGroup;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.mapper.AuthUserGroupMapper;
import com.moxi.xo.service.AuthUserGroupService;
import com.moxi.xo.vo.PermissionGroupVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import javax.annotation.Resource;
import java.util.Arrays;
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
public class AuthUserGroupServiceImpl extends SuperServiceImpl<AuthUserGroupMapper, AuthUserGroup> implements AuthUserGroupService {

    @Autowired
    AuthUserGroupService authUserGroupService;
    @Resource
    AuthUserGroupMapper authUserGroupMapper;

    @Override
    public String add(PermissionGroupVo vo) {
        if(StringUtils.isNotEmpty(vo.getMemberIds())){
            List<AuthUserGroup> userGroupList=Arrays.stream(vo.getMemberIds().split(SysConf.FILE_SEGMENTATION)).map(x->{
                return new AuthUserGroup(x,vo.getUid());
            }).collect(Collectors.toList());
            authUserGroupService.saveBatch(userGroupList);
        }
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String delete(PermissionGroupVo vo) {
        if(StringUtils.isNotEmpty(vo.getMemberIds())){
            List<String> memberIds=Arrays.asList(vo.getMemberIds().split(SysConf.FILE_SEGMENTATION));
            QueryWrapper<AuthUserGroup> wrapper=new QueryWrapper<AuthUserGroup>(){{
                in(SysConf.USERID,memberIds);
                eq(SysConf.RID,vo.getUid());
            }};
            authUserGroupMapper.delete(wrapper);
        }
        return null;
    }
}
