package com.moxi.xo.vo;

import com.moxi.base.vo.BaseVO;
import lombok.Data;
import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/14 12:54
 */
@Data
public class GapFillBankVo extends BaseVO<GapFillBankVo> {

    private List<GapFillVo> gapFillVoList;

    @Data
    public static class GapFillVo{
        private String uid;

        /**
         * 题目名称
         */
        private String name;

        /**
         * 题目题目/描述
         */
        private String questionTitle;

        /**
         * 题目编程内容
         */
        private String questionInfo;

        private String questionAnswer;
        /**
         * 发布者
         */
        private String publisher;

        private List<GapAnswer> gapAnswerList;
    }

    @Data
    public static class GapAnswer{

        private String fillAnswer;

        /**
         * 当前空格的位置,从1开始
         */
        private Integer fillNum;
    }
}
