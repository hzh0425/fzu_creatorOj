package com.moxi.teacherServer.restApi;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.moxi.base.exception.ThrowableUtils;
import com.moxi.base.validator.group.GetList;
import com.moxi.teacherServer.annotation.authority.AuthorityVerify;
import com.moxi.utils.ResultUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.service.ExamService;
import com.moxi.xo.vo.BankListVo;
import com.moxi.xo.vo.GapFillBankVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/14 15:07
 */
@RestController
@RequestMapping("/teacher/examBank")
@Api(value = "7.考试的题目相关接口", tags = {"7.考试的题目相关接口"})
public class ExamBankRestApi {

    @Autowired
    ExamService examService;

    @ApiOperation(value = "获取某场考试的某一题型的题目列表,会根据num字段排序,编程题只返回题目列表,需要再通过uid获取编程题的具体内容", notes = "获取某场考试的某一题型的题目列表", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"bankVoList","programId"})
    @PostMapping("/getListAsType")
    public String getListAsType(@Validated({GetList.class})@RequestBody BankListVo vo, BindingResult result) {
        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.result(SysConf.SUCCESS, examService.getListAsType(vo));
    }

    @ApiOperation(value = "为某场考试批量新增题目", notes = "为某场考试批量新增题目", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"programId","problemType","examId"})
    @PostMapping("/addProblemBatch")
    public String addProblemBatch(@RequestBody BankListVo vo) {
        //ThrowableUtils.checkParamArgument(result);
        return examService.addProblemBatch(vo);
    }

    @ApiOperation(value = "为某场考试删除题目", notes = "为某场考试删除题目", response = String.class)
    @DeleteMapping("/deleteProblem/{eid}/{bid}")
    public String deleteProblem(@PathVariable String eid,@PathVariable String bid) {
        if(StringUtils.isEmpty(eid))return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        if(StringUtils.isEmpty(bid))return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        return examService.deleteProblem(eid,bid);
    }
}
