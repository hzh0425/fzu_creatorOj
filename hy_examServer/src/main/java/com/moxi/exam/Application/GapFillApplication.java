package com.moxi.exam.Application;

import com.moxi.exam.factoryMethod.problemApplication;
import com.moxi.xo.mapper.GapBankMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 填空题处理器
 * @author hzh
 * @version 1.0
 * @date 2020/11/3 20:18
 */
@Component
public class GapFillApplication extends problemApplication {

    @Resource
    GapBankMapper bankMapper;
    /**
     * 从mysql 获取数据
     *
     * @param examId
     * @param stuId
     * @return
     */
    @Override
    public List getPageFromMysql(String examId, String stuId) {
        return null;
    }

    /**
     * 统计分析
     */
    @Override
    public void analyze() {

    }

    /**
     * 评分
     */
    @Override
    public void score() {

    }
}
