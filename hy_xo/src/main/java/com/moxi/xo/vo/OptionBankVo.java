package com.moxi.xo.vo;

import com.moxi.base.vo.BaseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/13 21:42
 */
@Data
@ApiModel("选择题题库 接收类")
public class OptionBankVo extends BaseVO<OptionBankVo> {
    @ApiModelProperty(value = "若申请的列表为私人题目,需要加上这个属性")
    private String publisherId;

    @ApiModelProperty(value = "申请获取的列表是否为公共题目(其他老师设置为可分享的,以及管理员公共上传的题目)")
    private int IsPublic;

    @ApiModelProperty(value = "选择题类型,1-单选题,2-多选题,3,判断题")
    private int optionType;
    @ApiModelProperty("选择题题库列表")
    private List<OptionVo> optionVoList;

    @ApiModel(value = "选择题 接收类"  )
    @Data
    public static class OptionVo{


        private String uid;
        /**
         * 题目题目/描述
         */

        @ApiModelProperty(value = "题目")
        private String questionTitle;


        /**
         * 1-单选题,2-多选题,3,判断题
         */
        @ApiModelProperty(value = "选择题类型,1-单选题,2-多选题,3,判断题 ")
        private Integer optionType;
        /**
         * 选项答案
         */
        @ApiModelProperty(value = "答案,如果有多个 则以,划分")
        private String questionAnswer;
        /**
         * 发布者
         */
        @ApiModelProperty(value = "发布者姓名")
        private String publisher;

        @ApiModelProperty(value = "发布者id")
        private String publisherId;

        @ApiModelProperty(value = "共享模式")
        private Integer shareMode;
        /**
         * 选项表
         */
        @ApiModelProperty(value = "选项列表")
        private List<OptionSelect> optionSelectList;

    }
    @Data
    public static  class OptionSelect{

        /**
         * 选项描述
         */
        @ApiModelProperty(value = "选项描述")
        private String optionDesc;

        /**
         * A,B,C,D
         */
        @ApiModelProperty(value = "第几个选项 A,B,C,D")
        private String optionNum;

    }
}
