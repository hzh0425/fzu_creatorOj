package com.moxi.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.moxi.codeBase.Interface.SuperService;
import com.moxi.xo.entity.Class;
import com.moxi.xo.vo.ClassVo;
import com.moxi.xo.vo.StuExamVo;

import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
public interface ClassService extends SuperService<Class> {

    public IPage<Class> getList(ClassVo teacherId);

    public String add(ClassVo vo);

    public String edit(ClassVo vo);

    public String delete(String classId);

    /**
     * 获取学生端班级列表
     * @param vo
     * @return
     */
    public IPage<Class> getListForStu(StuExamVo vo);

    /**
     * 学生加入班级
     * @param stuId
     * @param classId
     * @return
     */
    public String stuAddClass(String stuId, String classId);

    /**
     * 学生退出班级
     * @param stuId
     * @param classId
     * @return
     */
    public String stuRemoveClass(String stuId,String classId);
}
