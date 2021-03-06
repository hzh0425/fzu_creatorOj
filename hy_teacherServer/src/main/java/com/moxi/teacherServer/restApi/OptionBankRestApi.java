package com.moxi.teacherServer.restApi;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.moxi.base.exception.ThrowableUtils;
import com.moxi.base.validator.group.GetList;

import com.moxi.teacherServer.util.AccessTokenUtils;
import com.moxi.utils.ResultUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.service.ClassService;
import com.moxi.xo.service.OptionBankService;
import com.moxi.xo.service.ProgramBankService;
import com.moxi.xo.vo.ClassVo;
import com.moxi.xo.vo.OptionBankVo;
import com.moxi.xo.vo.ProgramBankVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/13 21:29
 */

@RestController
@RequestMapping("/problem/option")
@Api(value = "1.选择题相关接口", tags = {"1.选择题相关接口"})
public class OptionBankRestApi {
    @Autowired
    OptionBankService optionBankService;
    @Autowired
    AccessTokenUtils accessTokenUtils;

    @ApiOperation(value = "获取选择题列表(分页,支持根据keyword字段模糊查询),需要先传入", notes = "获取编程问题列表(分页,支持根据keyword字段模糊查询)", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"optionVoList","uid"})
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class})@RequestBody OptionBankVo vo, BindingResult result)
    {
        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.result(SysConf.SUCCESS, optionBankService.getList(vo));
    }

    @ApiOperation(value = "根据uid获取编程题具体题目", notes = "根据uid获取编程题具体题目", response = String.class)
    @GetMapping("/getById")
    public String getById(@RequestParam("pid")String pid,HttpServletRequest request)
    {
        String userId=accessTokenUtils.getUserId(request);
        return ResultUtil.result(SysConf.SUCCESS, optionBankService.getById(pid,userId));
    }

    @ApiOperation(value = "批量新增选择问题", notes = "批量新增选择问题", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"currentPage","pageSize","uid","keyword","optionType","isPublic","publisherId"})
    @PostMapping("/addBatch")
    public String addBatch(@RequestBody OptionBankVo vo) {
        //ThrowableUtils.checkParamArgument(result);
        return optionBankService.addBatch(vo);
    }

    @ApiOperation(value = "编辑选择问题", notes = "编辑选择问题", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"publisher","publisherId"})
    @PostMapping("/edit")
    public String edit(@RequestBody OptionBankVo.OptionVo vo,HttpServletRequest request) {
        //ThrowableUtils.checkParamArgument(result);
        String userId=accessTokenUtils.getUserId(request);
        return optionBankService.edit(vo,userId);
    }

    @ApiOperation(value = "删除选择问题", notes = "删除选择问题", response = String.class)
    @DeleteMapping("/delete/{oid}")
    public String delete(@PathVariable String oid, HttpServletRequest request) {
        if(StringUtils.isEmpty(oid))return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        String userId=accessTokenUtils.getUserId(request);
        return optionBankService.delete(userId,oid);
    }

}