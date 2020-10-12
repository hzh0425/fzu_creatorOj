package com.moxi.teacherServer.restApi;

import com.moxi.base.exception.ThrowableUtils;
import com.moxi.base.validator.group.GetList;
import com.moxi.base.validator.group.Insert;
import com.moxi.teacherServer.global.SysConf;
import com.moxi.utils.ResultUtil;
import com.moxi.xo.service.ClassService;
import com.moxi.xo.vo.ClassVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(value = "班级相关接口", tags = {"班级相关接口"})
public class classRestApi {
    @Autowired
    ClassService classService;



    @ApiOperation(value = "获取班级列表", notes = "获取班级列表", response = String.class)
    @GetMapping("/getList/{teacherId}")
    public String getList(@PathVariable String teacherId)
    {
        return ResultUtil.result(SysConf.SUCCESS, classService.getList(teacherId));
    }


    @ApiOperation(value = "新增班级", notes = "新增班级", response = String.class)
    @PostMapping("/add")
    public String add(@Validated({Insert.class}) @RequestBody ClassVo vo, BindingResult result) {
        ThrowableUtils.checkParamArgument(result);
        return classService.add(vo);
    }

    @ApiOperation(value = "更新班级信息", notes = "更新班级信息", response = String.class)
    @PostMapping("/edit")
    public String edit(@Validated({Update.class}) @RequestBody ClassVo vo) {
        return classService.edit(vo);
    }

    @ApiOperation(value = "删除班级", notes = "删除班级", response = String.class)
    @PostMapping("/delete/{classId}")
    public String delete(@PathVariable String classId){
        return classService.delete(classId);
    }
}

