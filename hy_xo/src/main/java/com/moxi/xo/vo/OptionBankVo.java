package com.moxi.xo.vo;

import com.moxi.base.vo.BaseVO;
import lombok.Data;
import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/13 21:42
 */
@Data
public class OptionBankVo extends BaseVO<OptionBankVo> {

    private int optionType;
    private List<OptionVo> optionVoList;
    @Data
    public static class OptionVo{


        private String uid;
        /**
         * 题目题目/描述
         */
        private String questionTitle;


        /**
         * 1-单选题,2-多选题,3,判断题
         */
        private Integer optionType;
        /**
         * 选项答案
         */
        private String questionAnswer;
        /**
         * 发布者
         */
        private String publisher;

        /**
         * 选项表
         */
        private List<OptionSelect> optionSelectList;

    }
    @Data
    public static  class OptionSelect{

        /**
         * 选项描述
         */
        private String optionDesc;

        /**
         * A,B,C,D
         */
        private String optionNum;

    }
}
