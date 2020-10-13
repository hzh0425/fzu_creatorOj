package com.moxi.xo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.moxi.base.entity.SuperEntity;
import com.moxi.base.serviceImpl.SuperServiceImpl;
import com.moxi.utils.FileUtil.ExcelUtil;
import com.moxi.utils.ResultUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.entity.AuthStudent;
import com.moxi.xo.entity.ClassStu;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.global.SqlConf;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.mapper.AuthStudentMapper;
import com.moxi.xo.service.AuthStudentService;
import com.moxi.xo.service.ClassStuService;
import com.moxi.xo.mapper.ClassStuMapper;
import com.moxi.xo.vo.ClassStuVo;
import com.moxi.xo.vo.StuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    AuthStudentMapper studentMapper;
    @Resource
    AuthStudentService studentService;
    @Resource
    ClassStuMapper classStuMapper;
    @Resource
    ClassStuService classStuService;
    @Autowired
    ExcelUtil excelUtil;


    @Override
    public List<AuthStudent> getList(String classId) {
        return classStuMapper.getStudentsByClassId(classId);
    }

    @Override
    public String add(ClassStuVo vo) {
        return null;
    }

    @Override
    public String deleteBatch(ClassStuVo vo) {
        QueryWrapper<ClassStu> wrapper=new QueryWrapper<>();
        wrapper.eq(SqlConf.CID,vo.getCid());
        wrapper.in(SqlConf.SID,vo.getSid().split(SysConf.FILE_SEGMENTATION));
        classStuMapper.delete(wrapper);
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.DELETE_SUCCESS);
    }


    @Override
    public String addFromExists(ClassStuVo vo) {
        String arr[]=vo.getSid().split(SysConf.FILE_SEGMENTATION);
        List<ClassStu> list=new ArrayList<>();
        Arrays.stream(arr).forEach(x->list.add(new ClassStu(x,vo.getCid())));
        classStuService.saveBatch(list);
        return ResultUtil.result(SysConf.SUCCESS,MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String addBatch(ClassStuVo vo) {
        List<StuVo> stuVoList = vo.getStuList();
        //1.先插入
        List<AuthStudent>  stuList=stuVoList.
                parallelStream()
                .filter(x->StringUtils.isNotEmpty(x.getStuNum()))
                .map(x->
                {
                    return new AuthStudent(x.getStuName(),x.getStuNum(),x.getStuSchool(),x.getStuMajor(),x.getStuGrade(),x.getStuClass());
                })
                .collect(Collectors.toList());
        if(stuList.size()==0)return ResultUtil.result(SysConf.SUCCESS,MessageConf.INSERT_SUCCESS);
        studentMapper.insertBatch(stuList);
        System.out.println("one done");
        //2.根据学校-学号查找 uid
        List<String> stuNums=stuList.stream().map(AuthStudent::getStuNum).collect(Collectors.toList());
        QueryWrapper<AuthStudent> wrapper=new QueryWrapper<>();
        wrapper.in(SqlConf.STU_NUMS,stuNums);
        wrapper.select(SqlConf.UID);
        List<String> stuUids=studentService.list(wrapper).stream().map(SuperEntity::getUid).collect(Collectors.toList());
        //3.插入学生,班级中间表
        List<ClassStu> classStus=studentService.list(wrapper).stream().map(x->{
            return new ClassStu(x.getUid(),vo.getCid());
        }).collect(Collectors.toList());;
        classStuService.saveBatch(classStus);
        return ResultUtil.result(SysConf.SUCCESS,MessageConf.INSERT_SUCCESS);
    }


    @Async
    @Override
    public void deleteBatchByClassId(String classId) {
        QueryWrapper<ClassStu> wrapper=new QueryWrapper<>();
        wrapper.eq(SqlConf.CID,classId);
        classStuMapper.delete(wrapper);
    }
}
