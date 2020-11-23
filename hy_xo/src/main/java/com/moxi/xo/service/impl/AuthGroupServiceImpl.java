package com.moxi.xo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.moxi.codeBase.Interface.SuperServiceImpl;
import com.moxi.codeBase.enums.EGroupType;
import com.moxi.codeBase.enums.EResourceType;
import com.moxi.codeBase.utils.ResultUtil;
import com.moxi.xo.entity.AuthGroup;
import com.moxi.xo.entity.Exam;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.global.SqlConf;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.mapper.AuthGroupMapper;

import com.moxi.xo.service.AuthGroupService;
import com.moxi.xo.service.ExamService;
import com.moxi.xo.util.ResourceUtil;
import com.moxi.xo.vo.PermissionGroupVo;
import com.moxi.xo.vo.ResourceReturningVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
public class AuthGroupServiceImpl extends SuperServiceImpl<AuthGroupMapper, AuthGroup> implements AuthGroupService {

    @Autowired
    AuthGroupService authGroupService;
    @Autowired
    ResourceUtil resourceUtil;
    @Autowired
    ExamService examService;
    @Override
    public IPage<AuthGroup> getList(PermissionGroupVo vo) {
        QueryWrapper<AuthGroup> wrapper=new QueryWrapper<AuthGroup>(){{
           eq(SqlConf.CLASS_ID,vo.getClassId());
           eq(SqlConf.GROUP_TYPE, EGroupType.CLASS_GROUP);
           if(StringUtils.isNotEmpty(vo.getKeyword())){
               like(SqlConf.GROUP_NAME,vo.getKeyword());
           }
           orderByDesc(SqlConf.CREATE_DATE);
        }};
        Page<AuthGroup> page=new Page<>(vo.getCurrentPage(),vo.getPageSize());
        return authGroupService.page(page,wrapper);
    }

    @Override
    public String add(PermissionGroupVo vo, String userId) {
        //1.先查询
        QueryWrapper<AuthGroup> wrapper=new QueryWrapper<AuthGroup>(){{
            eq(SqlConf.CLASS_ID,vo.getClassId());
            eq(SqlConf.GROUP_NAME,vo.getGroupName());
        }};
        int have=authGroupService.count(wrapper);
        if(have>0)return ResultUtil.result(SysConf.ERROR, MessageConf.GROUP_EXIST);
        //2.构造
        AuthGroup authGroup=new AuthGroup(vo.getGroupName(),vo.getGroupDesc(),EGroupType.CLASS_GROUP,vo.getClassId(),new Date(),new Date());
        authGroup.insert();
        //3.创建返回体
        ResourceReturningVo returningVo=new ResourceReturningVo(userId,MessageConf.INSERT_SUCCESS,authGroup.getUid(),SysConf.RESOURCE_PERMISSION_GROUP);
        //4.构建权限表
        resourceUtil.buildPermissionAfterAddResource(returningVo, EResourceType.RESOURCE_PERMISSION_GROUP);
        return ResultUtil.result(SysConf.SUCCESS,returningVo);
    }

    @Override
    public String edit(PermissionGroupVo vo) {
        //1.查询是否存在
        AuthGroup pre=authGroupService.getById(vo.getUid());
        if(pre==null)return ResultUtil.result(SysConf.ERROR,MessageConf.ENTITY_NOT_EXIST);
        pre.updateGroup(vo.getGroupName(),vo.getGroupDesc());
        return ResultUtil.result(SysConf.SUCCESS,MessageConf.UPDATE_SUCCESS);
    }

    @Override
    public String delete(String groupId) {
        //1.查询是否存在
        AuthGroup pre=authGroupService.getById(groupId);
        if(pre==null)return ResultUtil.result(SysConf.ERROR,MessageConf.ENTITY_NOT_EXIST);
        pre.deleteById();
        return ResultUtil.result(SysConf.SUCCESS,MessageConf.DELETE_SUCCESS);
    }

    @Override
    public List getPermissionTable(PermissionGroupVo vo) {
        //统一权限ids列表
        List<String> permissionIds=new ArrayList<>();
        //1.班级类资源
        String classId=vo.getClassId();
        //2.考试类资源
        // 查询考试列表
        QueryWrapper<Exam>examWrapper=new QueryWrapper<Exam>(){{
            eq(SqlConf.CLASS_ID,vo.getClassId());
        }};
        List<Exam> examList=examService.list(examWrapper);
        List<String> examIds=examList.stream().map(Exam::getUid).collect(Collectors.toList());
        //3.权限组资源类
        QueryWrapper<AuthGroup> groupWrapper=new QueryWrapper<AuthGroup>(){{
            eq(SqlConf.CLASS_ID,vo.getClassId());
        }};

        return null;
    }
}
