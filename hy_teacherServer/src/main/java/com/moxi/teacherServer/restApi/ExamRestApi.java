package com.moxi.teacherServer.restApi;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.moxi.base.exception.ThrowableUtils;
import com.moxi.base.validator.group.GetList;
import com.moxi.utils.ResultUtil;
import com.moxi.utils.ServerInfo.Sys;
import com.moxi.utils.StringUtils;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.service.ExamService;
import com.moxi.xo.vo.ExamVo;
import com.moxi.xo.vo.GapFillBankVo;
import com.moxi.xo.vo.OptionBankVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/13 20:03
 */
@RestController
@Api(value = "6.考试相关接口", tags = {"6.考试相关接口"})
public class ExamRestApi {

    @Autowired
    ExamService examService;


    @ApiOperation(value = "获取当前用户创建的考试列表(分页,支持根据keyword字段模糊查询)", notes = "获取当前用户创建的考试列表(分页,支持根据keyword字段模糊查询)", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"examBankVoList","startTime","endTime","uid","examName","publisher"})
    @PostMapping("/class/{classId}/exam/getList")
    public String getList(@PathVariable String classId,@Validated({GetList.class})@RequestBody ExamVo vo, BindingResult result)
    {
        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.result(SysConf.SUCCESS, examService.getList(classId,vo));
    }


    @ApiOperation(value = "新增考试", notes = "新增考试", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"currentPage","pageSize","uid","keyword"})
    @PostMapping("/class/{classId}/exam/add")
    public String addBatch(@PathVariable String classId,@RequestBody ExamVo vo) {
        //ThrowableUtils.checkParamArgument(result);
        return examService.add(classId,vo);
    }

    @ApiOperation(value = "编辑考试", notes = "编辑考试", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"currentPage","pageSize","keyword","tid","examBankVoList","publisher"})
    @PostMapping("/exam/{examId}/exam/edit")
    public String edit(@PathVariable String examId,@RequestBody ExamVo vo) {
        //ThrowableUtils.checkParamArgument(result);
        return examService.edit(vo);
    }

    @ApiOperation(value = "删除考试", notes = "删除考试", response = String.class)
    @DeleteMapping("/exam/{examId}/exam/delete")
    public String delete(@PathVariable String examId) {
        if(StringUtils.isEmpty(examId))return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        return examService.delete(examId);
    }
}
