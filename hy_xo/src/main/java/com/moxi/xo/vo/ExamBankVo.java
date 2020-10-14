package com.moxi.xo.vo;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/14 14:17
 */
@Data
public class ExamBankVo {

    public static class Exam{
        /**
         * 考试名
         */
        private String examName;

        /**
         * 开始时间
         */
        private Date startTime;

        /**
         * 结束时间
         */
        private Date endTime;

        /**
         * 发布者
         */
        private String publisher;
    }


}
