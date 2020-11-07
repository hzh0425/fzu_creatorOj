package com.moxi.exam.Application;

import com.alibaba.fastjson.JSON;
import com.moxi.base.enums.EProblemStatus;
import com.moxi.base.enums.EProblemType;
import com.moxi.exam.Template.problemApplication;
import com.moxi.utils.RedisUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.entity.OptionBank;
import com.moxi.xo.entity.OptionSelect;
import com.moxi.xo.entity.SubmitSelect;
import com.moxi.xo.mapper.OptionBankMapper;
import com.moxi.xo.service.OptionBankService;
import com.moxi.xo.service.SubmitSelectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 选择题处理器
 * @author hzh
 * @version 1.0
 * @date 2020/11/3 20:18
 */
@Component
public class OptionApplication implements problemApplication<OptionBank> {
    @Autowired
    RedisUtil redisUtil;

    @Resource
    OptionBankMapper optionBankMapper;
    @Autowired
    OptionBankService optionBankService;

    @Autowired
    SubmitSelectService submitSelectService;

    /**
     * 从mysql 获取数据
     *
     * @param examId
     * @param stuId
     * @return
     */
    @Override
    public List<OptionBank> getPageFromMysql(String examId, String stuId) {
        List<OptionBank> page= optionBankMapper.getExamOptionListForStu( examId );
        List<OptionBank> result=page.stream()
                .map( x-> {
                    if( StringUtils.isNotEmpty(x.getQuestionSelect()) ){
                        List<OptionSelect> list=JSON.parseArray( x.getQuestionSelect(), OptionSelect.class);
                        x.setSelectList( list );
                    }
                    x.setQuestionAnswer("");
                    return x;
                })
                .collect(Collectors.toList());
        return result;
    }

    /**
     * 当前处理器是否支持该事件
     *
     * @param type
     * @return
     */
    @Override
    public boolean support(int type) {
        return type== EProblemType.option;
    }

    /**
     * 提交答案
     *
     * @param examId
     * @param stuId
     * @param page
     */
    @Override
    public <T> void submit(String key,String examId, String stuId, List<T> page) {
        if( page.size() >0 && page.get(0) instanceof SubmitSelect ){
            List<OptionBank> preSubmit= getPageFromRedis( key , redisUtil );
            List<SubmitSelect> answers= page.stream()
                    .map(x->{
                        SubmitSelect s=(SubmitSelect)x;
                        s.setExamId( examId );
                        s.setUserId( stuId );
                        s.setScore( 0 );
                        s.setStatus( EProblemStatus.IM_JUDGE );
                        s.setSubmitTime( new Date() );
                        return s;
                    })
                    .collect(Collectors.toList());;
            if( preSubmit != null ){
                answers=answers.stream()
                        .filter( x-> !preSubmit.contains( x ))
                        .collect(Collectors.toList());
            }
             submitSelectService.saveBatch( answers );
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
