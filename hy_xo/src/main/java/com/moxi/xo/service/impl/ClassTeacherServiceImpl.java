package com.moxi.xo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.moxi.base.serviceImpl.SuperServiceImpl;
import com.moxi.xo.entity.ClassTeacher;
import com.moxi.xo.global.SqlConf;
import com.moxi.xo.mapper.ClassTeacherMapper;
import com.moxi.xo.service.ClassTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
@Service
public class ClassTeacherServiceImpl extends SuperServiceImpl<ClassTeacherMapper, ClassTeacher> implements ClassTeacherService {

    @Resource
    ClassTeacherMapper teacherMapper;

    @Async
    @Override
    public void deleteBatchByClassId(String classId) {
        QueryWrapper<ClassTeacher> wrapper=new QueryWrapper<>();
        wrapper.eq(SqlConf.CID,classId);
        teacherMapper.delete(wrapper);
    }
}
