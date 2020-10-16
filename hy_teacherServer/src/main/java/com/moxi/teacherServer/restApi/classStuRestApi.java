package com.moxi.teacherServer.restApi;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.moxi.base.exception.ThrowableUtils;
import com.moxi.base.validator.group.AddBatch;
import com.moxi.base.validator.group.GetList;
import com.moxi.base.validator.group.Insert;
import com.moxi.utils.ResultUtil;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.service.ClassService;
import com.moxi.xo.service.ClassStuService;
import com.moxi.xo.vo.ClassStuVo;
import com.moxi.xo.vo.ClassVo;
import com.moxi.xo.vo.StuVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/12 19:21
 */


@RestController
@RequestMapping("/teacher/classStu")
@Api(value = "5.班级-学生相关接口", tags = {"5.班级-学生相关接口"})
public class classStuRestApi {
    @Autowired
    ClassStuService classService;


    @ApiOperation(value = "获取班级的学生列表,keyword字段用于搜索学生名字", notes = "获取班级的学生列表", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"uid","sid","stuList"})
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class}) @RequestBody ClassStuVo vo, BindingResult result)
    {
        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.result(SysConf.SUCCESS, classService.getList(vo));
    }



    @ApiOperation(value = "从已有的学生中批量新增学生", notes = "从已有的学生中批量新增学生", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"uid","stuList","keyword","currentPage","pageSize"})
    @PostMapping("/addFromExists")
    public String add(@Validated({Insert.class}) @RequestBody ClassStuVo vo, BindingResult result) {
        ThrowableUtils.checkParamArgument(result);
        return classService.addFromExists(vo);
    }

    @ApiOperation(value = "批量增加学生(前端先解析,再统一发送过来)", notes = "批量增加学生(前端先解析,再统一发送过来)", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"uid","sid","keyword","currentPage","pageSize"})
    @PostMapping("/addBatch")
    public String addBatch(@RequestBody ClassStuVo vo) {
        //ThrowableUtils.checkParamArgument(result);
        if(vo.getStuList()==null||vo.getStuList().size()==0)return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        return classService.addBatch(vo);
    }


    @ApiOperation(value = "批量删除学生", notes = "批量删除学生", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"uid","keyword","currentPage","pageSize","stuList"})
    @PostMapping("/deleteBatch")
    public String delete(@Validated({Insert.class}) @RequestBody ClassStuVo vo, BindingResult result){
        ThrowableUtils.checkParamArgument(result);
        return classService.deleteBatch(vo);
    }
}


