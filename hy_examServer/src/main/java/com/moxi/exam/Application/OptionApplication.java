package com.moxi.exam.Application;

import com.alibaba.fastjson.JSON;
import com.moxi.exam.factoryMethod.problemApplication;
import com.moxi.utils.RedisUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.entity.OptionBank;
import com.moxi.xo.entity.OptionSelect;
import com.moxi.xo.entity.ProgramBank;
import com.moxi.xo.mapper.OptionBankMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 选择题处理器
 * @author hzh
 * @version 1.0
 * @date 2020/11/3 20:18
 */
@Component
public class OptionApplication extends problemApplication<OptionBank> {
    @Autowired
    RedisUtil redisUtil;

    @Resource
    OptionBankMapper optionBankMapper;

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
        List<OptionBank> result=page.stream().map( x-> {
            if( StringUtils.isNotEmpty(x.getQuestionSelect()) ){
                List<OptionSelect> list=JSON.parseArray( x.getQuestionSelect(), OptionSelect.class);
                x.setSelectList( list );
            }
            x.setQuestionAnswer("");
            return x;
        }).collect(Collectors.toList());
        return result;
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
