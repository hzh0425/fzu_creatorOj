package com.moxi.exam.Application;

import com.moxi.base.enums.EProblemStatus;
import com.moxi.exam.Template.problemApplication;
import com.moxi.utils.RedisUtil;
import com.moxi.xo.entity.ProgramBank;
import com.moxi.xo.entity.SubmitProgram;
import com.moxi.xo.mapper.ProgramBankMapper;
import com.moxi.xo.service.ProgramBankService;
import com.moxi.xo.service.SubmitProgramService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 编程题处理器
 * @author hzh
 * @version 1.0
 * @date 2020/11/3 20:18
 */
@Component
public class ProgramApplication implements problemApplication<ProgramBank> {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    ProgramBankService bankService;

    @Resource
    ProgramBankMapper bankMapper;

    @Autowired
    SubmitProgramService submitProgramService;
    /**
     * 从mysql 获取数据
     * @return
     */
    @Override
    public List getPageFromMysql(String examId, String stuId) {
        return bankMapper.getListForStu( examId );
    }

    /**
     * 提交答案
     *
     * @param examId
     * @param stuId
     * @param page
     */
    @Override
    public <T> void submit(String examId, String stuId, List<T> page) {
        if( page.size() > 0 && page.get(0) instanceof SubmitProgram){

            List<SubmitProgram> answers= page.stream()
                            .map( x->{
                                SubmitProgram program= (SubmitProgram) x;
                                program.setSubmitTime( new Date());
                                program.setExamId( examId );
                                program.setUserId( stuId );
                                program.setStatus( EProblemStatus.IM_JUDGE );
                                program.setJudgeResult( "wait" );
                                return program;
                            } )
                            .collect(Collectors.toList());
            submitProgramService.saveBatch( answers );
        }
    }


    /**
     * 评分
     */
    @Override
    public <T> void score() {

    }

    /**
     * 统计分析
     */
    @Override
    public <T> void analyze() {

    }


}
