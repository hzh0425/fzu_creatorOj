package com.moxi.xo.vo;

import com.moxi.base.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/14 12:54
 */
@Data
@ApiModel("填空题题库 接收类")
public class GapFillBankVo extends BaseVO<GapFillBankVo> {

    @ApiModelProperty(value = "若申请的列表为私人题目,需要加上这个属性")
    private String publisherId;

    @ApiModelProperty(value = "申请获取的列表是否为公共题目(其他老师设置为可分享的,以及管理员公共上传的题目)")
    private int IsPublic;


    @ApiModelProperty(value = "填空题题库题库")
    private List<GapFillVo> gapFillVoList;


    @Data
    @ApiModel("填空题 接收类")
    public static class GapFillVo{
        @ApiModelProperty(value = "uuid")
        private String uid;

        /**
         * 题目名称
         */
        @ApiModelProperty(value = "题目名称")
        private String name;

        /**
         * 题目题目/描述
         */
        @ApiModelProperty(value = "标题")
        private String questionTitle;

        /**
         * 题目编程内容
         */
        @ApiModelProperty(value = "内容")
        private String questionInfo;


        /**
         * 发布者
         */
        @ApiModelProperty(value = "发布者姓名")
        private String publisher;

        @ApiModelProperty(value = "发布者id")
        private String publisherId;

        @ApiModelProperty(value = "共享模式")
        private int shareMode;

        @ApiModelProperty(value = "答案列表")
        private List<GapAnswer> gapAnswerList;
    }

    @Data
    @ApiModel("填空题答案")
    public static class GapAnswer{


        @ApiModelProperty(value = "答案")
        private String fillAnswer;

        /**
         * 当前空格的位置,从1开始
         */
        @ApiModelProperty(value = "当前的空格")
        private Integer fillNum;
    }
}
