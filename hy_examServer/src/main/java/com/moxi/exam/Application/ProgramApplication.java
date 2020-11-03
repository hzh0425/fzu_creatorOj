package com.moxi.exam.Application;

import com.moxi.exam.factoryMethod.problemApplication;
import com.moxi.utils.RedisUtil;
import com.moxi.xo.entity.ProgramBank;
import com.moxi.xo.mapper.ProgramBankMapper;
import com.moxi.xo.service.ProgramBankService;
import com.moxi.xo.vo.programVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 编程题处理器
 * @author hzh
 * @version 1.0
 * @date 2020/11/3 20:18
 */
@Component
public class ProgramApplication extends problemApplication<ProgramBank> {

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    ProgramBankService bankService;

    @Resource
    ProgramBankMapper bankMapper;

    /**
     * 从mysql 获取数据
     * @return
     */
    @Override
    public List getPageFromMysql(String examId, String stuId) {
        return bankMapper.getListForStu( examId );
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
