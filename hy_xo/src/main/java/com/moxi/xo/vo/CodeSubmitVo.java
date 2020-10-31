package com.moxi.xo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/31 11:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeSubmitVo {
    private String eventType;
    /**
     * 用户id
     */
    private String userId;

    /**
     * 考试的id
     */
    private String examId;

    /**
     * 考试的题库id
     */
    private String bankId;

    /**
     * 语言
     */
    private String language;

    /**
     * 提交的代码
     */
    private String submitCode;
}
