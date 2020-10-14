package com.moxi.xo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.moxi.base.serviceImpl.SuperServiceImpl;
import com.moxi.utils.ResultUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.entity.ExamBank;
import com.moxi.xo.entity.OptionBank;
import com.moxi.xo.global.MessageConf;
import com.moxi.xo.global.SqlConf;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.mapper.ExamMapper;
import com.moxi.xo.service.ExamBankService;
import com.moxi.xo.service.ExamService;
import com.moxi.xo.entity.Exam;
import com.moxi.xo.vo.ExamVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
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
public class ExamServiceImpl extends SuperServiceImpl<ExamMapper, Exam> implements ExamService {

    @Autowired
    ExamService examService;
    @Autowired
    ExamBankService examBankService;


    @Override
    public IPage<Exam> getList(ExamVo vo) {

        QueryWrapper<Exam> wrapper=new QueryWrapper<>();
        if(StringUtils.isNotEmpty(vo.getKeyword())){
            wrapper.eq(SqlConf.EXAM_NAME,vo.getKeyword());
        }
        wrapper.eq(SqlConf.TID,vo.getTid());
        wrapper.orderByDesc(SqlConf.CREATE_DATE);
        Page<Exam> page=new Page<>(vo.getCurrentPage(),vo.getPageSize());
        return examService.page(page,wrapper);
    }

    @Override
    public String add(ExamVo vo) {
        //1.创建考试,获取eid
        Exam exam=new Exam(vo.getTid(),vo.getExamName(),vo.getStartTime(),vo.getEndTime(),vo.getPublisher());
        exam.insert();
        String eid=exam.getUid();
        //2.创建考试对应的题目集
        List<ExamBank> bankList=vo.getExamBankVoList().stream().parallel()
                .map(x->{
                    return new ExamBank(eid,x.getBid(),x.getType(),x.getNum(),x.getScore());
                }).collect(Collectors.toList());
        examBankService.saveBatch(bankList);
        return ResultUtil.result(SysConf.SUCCESS, MessageConf.INSERT_SUCCESS);
    }

    @Override
    public String delete(String eid) {
        Exam pre=examService.getById(eid);
        if(pre==null)return ResultUtil.result(SysConf.ERROR,MessageConf.ENTITY_NOT_EXIST);
        pre.deleteById();
        return ResultUtil.result(SysConf.SUCCESS,MessageConf.DELETE_SUCCESS);
    }

    @Override
    public String eid(ExamVo vo) {
        Exam pre=examService.getById(vo.getUid());
        if(pre==null)return ResultUtil.result(SysConf.ERROR,MessageConf.ENTITY_NOT_EXIST);
        pre.UpdateExam(vo.getExamName(),vo.getStartTime(),vo.getEndTime());
        pre.updateById();
        return ResultUtil.result(SysConf.SUCCESS,MessageConf.UPDATE_SUCCESS);
    }
}
