package com.moxi.xo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("考试创建的题目 接受类")
public  class examBankVo{
        /**
         * exam id
         */
        @ApiModelProperty(value = "examId")
        private String eid;

        /**
         * 题目id
         */
        @ApiModelProperty(value = "bank Id")
        private String bid;

        /**
         * 题目类型 1_选择,2_填空,3_编程
         */
        @ApiModelProperty(value = "题目类型,1_选择,2_填空,3_编程")
        private Integer type;

        /**
         * 题目序号,对于每种类型的题目,以num进行排序
         */
        @ApiModelProperty(value = "题目序号,对于每种类型的题目,以num进行排序")
        private Integer num;

        /**
         * 题目分数
         */
        @ApiModelProperty(value = "该题分数")
        private String score;
}