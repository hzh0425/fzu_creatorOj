package com.moxi.teacherServer.restApi;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.moxi.base.exception.ThrowableUtils;
import com.moxi.base.validator.group.Delete;
import com.moxi.base.validator.group.GetList;
import com.moxi.base.validator.group.Insert;

import com.moxi.teacherServer.util.AccessTokenUtils;
import com.moxi.utils.ResultUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.entity.ProgramBank;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.service.ClassService;
import com.moxi.xo.service.ProgramBankService;
import com.moxi.xo.vo.ClassVo;
import com.moxi.xo.vo.ProgramBankVo;

import com.netflix.client.http.HttpRequest;
import io.netty.util.internal.ThrowableUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/13 20:03
 */
@RestController
@RequestMapping("/problem/program")
@Api(value = "3.编程题相关接口", tags = {"3.编程题相关接口"})
public class ProgramBankRestApi {
    @Autowired
    ProgramBankService programBankService;
    @Autowired
    AccessTokenUtils accessTokenUtils;

    @ApiOperation(value = "获取编程问题列表(分页,支持根据keyword字段模糊查询)", notes = "获取编程问题列表(分页,支持根据keyword字段模糊查询)", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"programVoList","uid"})
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class})@RequestBody ProgramBankVo vo, BindingResult result)
    {

        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.result(SysConf.SUCCESS, programBankService.getList(vo));
    }

    @ApiOperation(value = "批量新增编程问题", notes = "批量新增编程问题", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"currentPage","pageSize","uid","keyword"})
    @PostMapping("/addBatch")
    public String addBatch(@RequestBody ProgramBankVo vo) {
        //ThrowableUtils.checkParamArgument(result);
        return programBankService.addBatch(vo);
    }

    @ApiOperation(value = "编辑编程问题", notes = "编辑编程问题", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"publisher","publisherId"})
    @PostMapping("/edit")
    public String edit(@RequestBody ProgramBankVo.ProgramVo vo,HttpServletRequest request) {
        //ThrowableUtils.checkParamArgument(result);
        String userId=accessTokenUtils.getUserId(request);
        return programBankService.edit(vo,userId);
    }

    @ApiOperation(value = "删除编程问题", notes = "删除编程问题", response = String.class)
    @DeleteMapping("/delete/{programId}")
    public String delete(@PathVariable String programId, HttpServletRequest request) {
        if(StringUtils.isEmpty(programId))return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        String userId=accessTokenUtils.getUserId(request);
        return programBankService.delete(programId,userId);
    }
}

