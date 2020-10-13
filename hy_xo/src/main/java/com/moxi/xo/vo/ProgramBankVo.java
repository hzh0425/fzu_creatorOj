package com.moxi.xo.vo;

import com.moxi.base.vo.BaseVO;
import com.moxi.xo.entity.ProgramExample;
import lombok.Data;
import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/13 20:29
 */
@Data
public class ProgramBankVo extends BaseVO<ProgramBankVo> {
    List<ProgramVo> programVoList;

    @Data
    public static class ProgramVo  {

        private String uid;
        /**
         * 题目的题目/描述
         */
        private String questionTitle;

        /**
         * 题目内容
         */
        private String questionContent;
        /**
         * 题目时间上限
         */
        private Integer upperTime;

        /**
         * 题目内存上限
         */
        private Integer upperMemory;

        /**
         * 发布者
         */
        private String publisher;

        /**
         * 题目示例
         */
        private List<ProgramExampleVo> exampleVoList;
    }

    @Data
    public static class ProgramExampleVo{
        /**
         * 示例数据
         */
        private String data;

        /**
         * 示例结果
         */
        private String result;
    }
}
