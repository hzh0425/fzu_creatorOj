package com.moxi.xo.vo;

import com.moxi.base.vo.BaseVO;
import com.moxi.xo.entity.ProgramExample;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/13 20:29
 */
@Data
@ApiModel("编程题题库接收类")
public class ProgramBankVo extends BaseVO<ProgramBankVo> {

    @ApiModelProperty(value = "编程题列表")
    List<ProgramVo> programVoList;

    @Data
    @ApiModel("编程题接收类")
    public static class ProgramVo  {



        private String uid;
        /**
         * 题目的题目/描述
         */
        @ApiModelProperty(value = "编程题题目")
        private String questionTitle;

        /**
         * 题目内容
         */
        @ApiModelProperty(value = "编程题内容,markDown格式")
        private String questionContent;
        /**
         * 题目时间上限
         */
        @ApiModelProperty(value = "题目时间上限")
        private Integer upperTime;

        /**
         * 题目内存上限
         */
        @ApiModelProperty(value = "题目内存上限")
        private Integer upperMemory;

        /**
         * 发布者
         */
        @ApiModelProperty(value = "发布者姓名")
        private String publisher;

        /**
         * 发布者id
         */
        @ApiModelProperty(value = "发布者id")
        private String publisherId;

        /**
         * 共享模式 0-不共享,1-只读共享,2-读写共享
         */
        @ApiModelProperty(value = "共享模式 0-不共享,1-只读共享,2-读写共享")
        private int shareMode;


        /**
         * 题目示例
         */
        @ApiModelProperty(value = "题目示例列表")
        private List<ProgramExampleVo> exampleVoList;
    }

    @Data
    @ApiModel("题目示例 接收类")
    public static class ProgramExampleVo{
        /**
         * 示例数据
         */
        @ApiModelProperty(value = "示例数据 ")
        private String data;

        /**
         * 示例结果
         */
        @ApiModelProperty(value = "示例结果")
        private String result;
    }
}
