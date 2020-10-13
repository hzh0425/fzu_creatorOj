package com.moxi.teacherServer.restApi;

import com.moxi.base.exception.ThrowableUtils;
import com.moxi.base.validator.group.Delete;
import com.moxi.base.validator.group.GetList;
import com.moxi.base.validator.group.Insert;
import com.moxi.utils.ResultUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.entity.ProgramBank;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.service.ClassService;
import com.moxi.xo.service.ProgramBankService;
import com.moxi.xo.vo.ClassVo;
import com.moxi.xo.vo.ProgramBankVo;

import io.netty.util.internal.ThrowableUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/13 20:03
 */
@RestController
@RequestMapping("/problem/program")
@Api(value = "编程题相关接口", tags = {"编程题相关接口"})
public class ProgramBankRestApi {
    @Autowired
    ProgramBankService programBankService;

    @ApiOperation(value = "获取编程问题列表(分页,支持根据keyword字段模糊查询)", notes = "获取编程问题列表(分页,支持根据keyword字段模糊查询)", response = String.class)
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class})@RequestBody ProgramBankVo vo, BindingResult result)
    {
        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.result(SysConf.SUCCESS, programBankService.getList(vo));
    }

    @ApiOperation(value = "批量新增编程问题", notes = "批量新增编程问题", response = String.class)
    @PostMapping("/addBatch")
    public String addBatch(@RequestBody ProgramBankVo vo) {
        //ThrowableUtils.checkParamArgument(result);
        return programBankService.addBatch(vo);
    }

    @ApiOperation(value = "编辑编程问题", notes = "编辑编程问题", response = String.class)
    @PostMapping("/edit")
    public String edit(@RequestBody ProgramBankVo.ProgramVo vo) {
        //ThrowableUtils.checkParamArgument(result);
        return programBankService.edit(vo);
    }

    @ApiOperation(value = "删除编程问题", notes = "删除编程问题", response = String.class)
    @DeleteMapping("/delete/{pid}")
    public String delete(@PathVariable String pid) {
        if(StringUtils.isEmpty(pid))return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        return programBankService.delete(pid);
    }

}

