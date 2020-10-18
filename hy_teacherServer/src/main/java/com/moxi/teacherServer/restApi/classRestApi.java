package com.moxi.teacherServer.restApi;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.moxi.base.exception.ThrowableUtils;
import com.moxi.base.validator.group.GetList;
import com.moxi.base.validator.group.Insert;
import com.moxi.teacherServer.annotation.authority.AuthorityVerify;
import com.moxi.teacherServer.annotation.permissionLog.permissionLogVerify;
import com.moxi.teacherServer.global.SysConf;
import com.moxi.utils.ResultUtil;
import com.moxi.utils.ServerInfo.Sys;
import com.moxi.xo.service.ClassService;
import com.moxi.xo.vo.ClassVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/12 14:16
 */


/**
 * @author hzh
 * @version 1.0
 * @date 2020/9/17 15:59
 */
@RestController
@RequestMapping("/teacher/class")
@Api(value = "4.班级相关接口", tags = {"4.班级相关接口"})
public class classRestApi {
    @Autowired
    ClassService classService;



    @ApiOperation(value = "获取班级列表", notes = "获取班级列表,keyword可选,用于模糊查询", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"className","classDesc","creator","uid"})
    @PostMapping("/getList")
    public String getList(@RequestBody ClassVo vo)
    {
        return ResultUtil.result(SysConf.SUCCESS, classService.getList(vo));
    }



//    @permissionLogVerify(
//            resourceType = SysConf.RESOURCE_CLASS,
//            operationType = {SysConf.OPERATION_ADD,SysConf.OPERATION_DELETE,SysConf.OPERATION_EDIT,SysConf.OPERATION_GETLIST},
//            operand = {SysConf.OPERAND_STU,SysConf.OPERAND_EXAM, SysConf.OPERAND_PERMISSION_GROUP}
//            )
    @ApiOperation(value = "新增班级", notes = "新增班级", response = String.class)
    @ApiOperationSupport(ignoreParameters ={"uid","currentPage","pageSize","keyword"})
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody ClassVo vo, BindingResult result) {
        ThrowableUtils.checkParamArgument(result);
        return classService.add(vo);
    }

    @ApiOperation(value = "更新班级信息", notes = "更新班级信息", response = String.class)
    @ApiOperationSupport(ignoreParameters ={"currentPage","teacherId","pageSize","keyword"})
    @PostMapping("/edit")
    public String edit(@Validated({Update.class}) @RequestBody ClassVo vo) {
        return classService.edit(vo);
    }


    @ApiOperation(value = "删除班级", notes = "删除班级", response = String.class)
    @DeleteMapping("/delete/{classId}")
    public String delete(@PathVariable String classId){
        return classService.delete(classId);
    }
}

