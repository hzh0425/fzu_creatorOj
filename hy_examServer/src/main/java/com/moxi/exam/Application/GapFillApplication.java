package com.moxi.exam.Application;

import com.moxi.base.enums.EProblemType;
import com.moxi.exam.Template.problemApplication;
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
public class GapFillApplication implements problemApplication {

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
     * 当前处理器是否支持该事件
     *
     * @param type
     * @return
     */
    @Override
    public boolean support(int type) {
        return type== EProblemType.gapFill;
    }

    /**
     * 提交答案
     *
     * @param examId
     * @param stuId
     * @param page
     */
    @Override
    public void submit(String key,String examId, String stuId, List page) {

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
