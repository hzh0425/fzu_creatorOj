package com.moxi.xo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moxi.base.enums.EStatus;
import com.moxi.base.serviceImpl.SuperServiceImpl;
import com.moxi.utils.ResultUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.entity.Class;
import com.moxi.xo.entity.ClassTeacher;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.global.SqlConf;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.mapper.ClassMapper;
import com.moxi.xo.service.ClassService;
import com.moxi.xo.service.ClassStuService;
import com.moxi.xo.service.ClassTeacherService;
import com.moxi.xo.vo.ClassVo;
import com.moxi.xo.vo.ResourceReturningVo;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
@Service
public class ClassServiceImpl extends SuperServiceImpl<ClassMapper, Class> implements ClassService {

    @Autowired
    ClassService classService;
    @Resource
    ClassMapper classMapper;
    @Autowired
    ClassTeacherService classTeacherService;
    @Autowired
    ClassStuService classStuService;
    @Override
    public IPage<Class> getList(ClassVo vo) {
        Page<Class> page=new Page<>(vo.getCurrentPage(),vo.getPageSize());
        QueryWrapper<Class> wrapper=new QueryWrapper<>();
        wrapper.eq(SqlConf.TID,vo.getTeacherId());
        wrapper.eq(SqlConf.VALID,EStatus.ENABLE);
        if(StringUtils.isNotEmpty(vo.getKeyword())){
            wrapper.like(SqlConf.CLASS_NAME,vo.getKeyword());
        }
        return classMapper.getListByTeacherId(page,wrapper);
    }

    @Override
    public String add(ClassVo vo) {
        //1.查询该班级名称是否已经存在
        QueryWrapper<Class> wrapper=new QueryWrapper<>();
        wrapper.eq(SqlConf.CLASS_NAME,vo.getClassName());
        wrapper.eq(SqlConf.CREATOR,vo.getCreator());
        Class pre=classService.getOne(wrapper);
        if(pre!=null){
            return ResultUtil.result(SysConf.ERROR, MessageConf.CLASS_EXIST);
        }
        //2.创建并插入
        Class cur=new Class(vo.getClassName(),vo.getClassDesc(),0,vo.getCreator(), EStatus.ENABLE,new Date(),new Date());
        cur.insert();
        //3.创建教师-班级中间表
        ClassTeacher ct=new ClassTeacher(vo.getTeacherId(),cur.getUid());
        ct.insert();

        //4.创建返回体
        String permissionUrl="/class/"+cur.getUid();
        ResourceReturningVo templateVo=new ResourceReturningVo(vo.getTeacherId(),permissionUrl,MessageConf.INSERT_SUCCESS);
        return ResultUtil.result(SysConf.SUCCESS,templateVo);
    }

    @Override
    public String edit(ClassVo vo) {
        //1.查询该班级是否存在
        QueryWrapper<Class> wrapper=new QueryWrapper<>();
        wrapper.eq(SqlConf.UID,vo.getUid());
        Class pre=classService.getOne(wrapper);
        if(pre==null){
            return ResultUtil.result(SysConf.ERROR,MessageConf.ENTITY_NOT_EXIST);
        }
        pre.setClassDesc(vo.getClassDesc());
        pre.setClassName(vo.getClassName());
        pre.updateById();
        return ResultUtil.result(SysConf.SUCCESS,MessageConf.UPDATE_SUCCESS);
    }

    @Override
    public String delete(String classId) {
        //1.查询该班级是否存在
        QueryWrapper<Class> wrapper=new QueryWrapper<>();
        wrapper.eq(SqlConf.UID,classId);
        Class pre=classService.getOne(wrapper);
        if(pre==null){
            return ResultUtil.result(SysConf.ERROR,MessageConf.ENTITY_NOT_EXIST);
        }
        QueryWrapper<ClassTeacher> teacherWrapper=new QueryWrapper<>();
        teacherWrapper.eq(SqlConf.CID,pre.getUid());
        pre.deleteById();
        //2.删除中间表记录
        deleteMidTableLogByClassId(classId);
        return ResultUtil.result(SysConf.SUCCESS,MessageConf.DELETE_SUCCESS);
    }

    @Async
    public void deleteMidTableLogByClassId(String classId){
        classTeacherService.deleteBatchByClassId(classId);
        classStuService.deleteBatchByClassId(classId);
    }
}
