package com.moxi.xo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.moxi.base.serviceImpl.SuperServiceImpl;
import com.moxi.xo.entity.ClassStu;
import com.moxi.xo.global.SqlConf;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.service.ClassStuService;
import com.moxi.xo.mapper.ClassStuMapper;
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
public class ClassStuServiceImpl extends SuperServiceImpl<ClassStuMapper, ClassStu> implements ClassStuService {

    @Resource
    ClassStuMapper stuMapper;
    @Async
    @Override
    public void deleteBatchByClassId(String classId) {
        QueryWrapper<ClassStu> wrapper=new QueryWrapper<>();
        wrapper.eq(SqlConf.CID,classId);
        stuMapper.delete(wrapper);
    }
}
