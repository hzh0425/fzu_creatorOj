package com.moxi.teacherServer.restApi;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.moxi.base.exception.ThrowableUtils;
import com.moxi.base.validator.group.GetList;
import com.moxi.teacherServer.util.AccessTokenUtils;
import com.moxi.utils.ResultUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.service.GapBankService;
import com.moxi.xo.service.ProgramBankService;
import com.moxi.xo.vo.GapFillBankVo;
import com.moxi.xo.vo.ProgramBankVo;
import com.netflix.ribbon.proxy.annotation.Http;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/problem/gapFill")
@Api(value = "2.填空题相关接口", tags = {"2.填空题相关接口"})
public class GapFillBankRestApi {
    @Autowired
    GapBankService gapBankService;
    @Autowired
    AccessTokenUtils accessTokenUtils;
    @ApiOperation(value = "获取填空题问题列表(分页,支持根据keyword字段模糊查询)", notes = "获取填空题问题列表(分页,支持根据keyword字段模糊查询)", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"gapFillVoList","uid"})
    @PostMapping("/getList")
    public String getList(@Validated({GetList.class})@RequestBody GapFillBankVo vo, BindingResult result)
    {
        ThrowableUtils.checkParamArgument(result);
        return ResultUtil.result(SysConf.SUCCESS, gapBankService.getList(vo));
    }


    @ApiOperation(value = "批量新增填空题问题", notes = "批量新增填空题问题", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"currentPage","pageSize","uid","keyword"})
    @PostMapping("/addBatch")
    public String addBatch(@RequestBody GapFillBankVo vo) {
        //ThrowableUtils.checkParamArgument(result);
        return gapBankService.addBatch(vo);
    }

    @ApiOperation(value = "编辑填空题问题", notes = "编辑填空题问题", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"publisher"})
    @PostMapping("/edit")
    public String edit(@RequestBody GapFillBankVo.GapFillVo vo, HttpServletRequest request) {
        //ThrowableUtils.checkParamArgument(result);
        String userId=accessTokenUtils.getUserId(request);
        return gapBankService.edit(vo,userId);
    }

    @ApiOperation(value = "删除填空题问题", notes = "删除填空题问题", response = String.class)
    @DeleteMapping("/delete/{gid}")
    public String delete(@PathVariable String gid, HttpServletRequest request) {
        if(StringUtils.isEmpty(gid))return ResultUtil.result(SysConf.ERROR, MessageConf.PARAM_INCORRECT);
        String userId=accessTokenUtils.getUserId(request);
        return gapBankService.delete(userId,gid);
    }

}