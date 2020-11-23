package com.moxi.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;

import com.moxi.codeBase.Interface.SuperService;
import com.moxi.xo.entity.Exam;
import com.moxi.xo.vo.BankListVo;
import com.moxi.xo.vo.ExamVo;
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
public interface ExamService extends SuperService<Exam> {

    /**
     * 教师端api
     */
    public IPage<Exam> getList(String classId, ExamVo vo);

    public String add(String classId, ExamVo vo);

    public String delete(String eid);

    public String edit(ExamVo vo);

    public List getListAsType(BankListVo vo);

    public String addProblemBatch(BankListVo vo);

    public String deleteProblem(String eid, String bid);


    /**
     * 学生端api
     */
    public IPage<Exam> getListForStu(StuExamVo vo);

    public IPage getProblemList(String examId,int problemType);

    public IPage doGetProblemList(String examId,int ... problemTypes);
}
