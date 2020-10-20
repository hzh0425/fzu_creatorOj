package com.moxi.teacherServer.restApi;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.moxi.base.exception.ThrowableUtils;
import com.moxi.base.validator.group.GetList;
import com.moxi.base.validator.group.Insert;
import com.moxi.teacherServer.global.SysConf;
import com.moxi.utils.ResultUtil;
import com.moxi.utils.ServerInfo.Sys;
import com.moxi.utils.StringUtils;
import com.moxi.xo.global.MessageConf;
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
@RequestMapping("/class")
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

    @ApiOperation(value = "新增班级", notes = "新增班级", response = String.class)
    @ApiOperationSupport(ignoreParameters ={"uid","currentPage","pageSize","keyword"})
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody ClassVo vo, BindingResult result) {
        ThrowableUtils.checkParamArgument(result);
        return classService.add(vo);
    }

    @ApiOperation(value = "更新班级信息", notes = "更新班级信息", response = String.class)
    @ApiOperationSupport(ignoreParameters ={"currentPage","teacherId","pageSize","keyword"})
    @PostMapping("/{classId}/class/edit")
    public String edit(@PathVariable String classId,@Validated({Update.class}) @RequestBody ClassVo vo) {
        if(StringUtils.isEmpty(classId))return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        return classService.edit(vo);
    }


    @ApiOperation(value = "删除班级", notes = "删除班级", response = String.class)
    @DeleteMapping("/{classId}/class/delete")
    public String delete(@PathVariable String classId){
        if(StringUtils.isEmpty(classId))return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        return classService.delete(classId);
    }
}

