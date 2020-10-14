package com.moxi.xo.vo;

import lombok.Data;

@Data
public  class examBankVo{
        /**
         * exam id
         */
        private String eid;

        /**
         * 题目id
         */
        private String bid;

        /**
         * 题目类型 1_选择,2_填空,3_编程
         */
        private Integer type;

        /**
         * 题目序号,对于每种类型的题目,以num进行排序
         */
        private Integer num;

        /**
         * 题目分数
         */
        private String score;
}