package com.moxi.teacherServer.restApi;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.moxi.base.exception.ThrowableUtils;
import com.moxi.base.validator.group.Insert;
import com.moxi.teacherServer.global.SysConf;
import com.moxi.teacherServer.util.AccessTokenUtils;
import com.moxi.utils.ResultUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.service.*;
import com.moxi.xo.vo.ClassVo;
import com.moxi.xo.vo.PermissionGroupVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/17 15:38
 */
@RestController
@Api(value = "8.权限组相关", tags = {"8.权限组相关"})
public class permissionGroupRestApi {
    //0.获取权限组列表
    @Autowired
    ClassService classService;
    @Autowired
    AuthPermissionService authPermissionService;
    @Autowired
    AuthGroupService authGroupService;
    @Autowired
    AuthGroupPermissionService authGroupPermissionService;
    @Autowired
    AccessTokenUtils accessTokenUtils;
    @Autowired
    AuthUserGroupService authUserGroupService;


    @ApiOperation(value = "1.获取权限组列表", notes = "1.获取权限组列表,keyword可选,用于模糊查询", response = String.class)
    @PostMapping("/class/{classId}/permissionGroup/getList")
    public String getList(@PathVariable String classId,@RequestBody PermissionGroupVo vo)
    {
        if(StringUtils.isEmpty(classId))return ResultUtil.result(SysConf.ERROR,MessageConf.PARAM_INCORRECT);
        return ResultUtil.result(SysConf.SUCCESS, authGroupService.getList(vo));
    }


    //1.创建权限组
    @ApiOperation(value = "2.新增权限组", notes = "2.新增权限组新增班级", response = String.class)
    @PostMapping("/class/{classId}/permissionGroup/add")
    public String add(@PathVariable String classId, @RequestBody PermissionGroupVo vo, HttpServletRequest request) {
        if(StringUtils.isEmpty(classId))return ResultUtil.result(SysConf.ERROR,MessageConf.PARAM_INCORRECT);
        String userId=accessTokenUtils.getUserId(request);
        return authGroupService.add(vo,userId);
    }



    //2.编辑权限组
    @ApiOperation(value = "3.编辑权限组", notes = "3.编辑权限组", response = String.class)
    @PostMapping("/permissionGroup/{groupId}/permissionGroup/edit")
    public String edit(@PathVariable String groupId, @Validated({Update.class}) @RequestBody PermissionGroupVo vo) {
        if(StringUtils.isEmpty(groupId))return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        return authGroupService.edit(vo);
    }



    //3.删除权限组
    @ApiOperation(value = "4.删除权限组", notes = "4.删除权限组", response = String.class)
    @DeleteMapping("/permissionGroup/{groupId}/permissionGroup/delete")
    public String delete(@PathVariable String groupId){
        if(StringUtils.isEmpty(groupId))return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        return authGroupService.delete(groupId);
    }

    //4.为权限组赋予权限
    @ApiOperation(value = "5.为权限组赋予权限", notes = "5.为权限组赋予权限", response = String.class)
    @PostMapping("/permissionGroup/{groupId}/permission/add")
    public String addPermission(@PathVariable String groupId, @Validated({Update.class}) @RequestBody PermissionGroupVo vo) {
        if(StringUtils.isEmpty(groupId))return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        return authGroupPermissionService.add(vo);
    }
    //5.为权限组删除权限
    @ApiOperation(value = "6.为权限组删除权限", notes = "6.为权限组删除权限", response = String.class)
    @PostMapping("/permissionGroup/{groupId}/permission/delete")
    public String deletePermission(@PathVariable String groupId, @Validated({Update.class}) @RequestBody PermissionGroupVo vo) {
        if(StringUtils.isEmpty(groupId))return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        return authGroupPermissionService.delete(vo);
    }
    //6.为权限组增加成员
    @ApiOperation(value = "7.为权限组增加成员", notes = "4.为权限组增加成员", response = String.class)
    @PostMapping("/permissionGroup/{groupId}/member/add")
    public String addMember(@PathVariable String groupId, @Validated({Update.class}) @RequestBody PermissionGroupVo vo) {
        if(StringUtils.isEmpty(groupId))return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        return authUserGroupService.add(vo);
    }
    //7.为权限组删除成员
    @ApiOperation(value = "8.为权限组删除成员", notes = "8.为权限组删除成员", response = String.class)
    @PostMapping("/permissionGroup/{groupId}/member/delete")
    public String deleteMember(@PathVariable String groupId, @Validated({Update.class}) @RequestBody PermissionGroupVo vo) {
        if(StringUtils.isEmpty(groupId))return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        return authUserGroupService.delete(vo);
    }
}
