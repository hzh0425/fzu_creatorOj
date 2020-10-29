package com.moxi.xo.entity;

import com.moxi.base.entity.SuperEntity;

import java.time.LocalDate;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/29 20:21
 */
public class SubmitFill extends SuperEntity {

    private static final long serialVersionUID = 1L;

    private String uid;

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
     * 提交的答案,A,B,C,D
     */
    private String response;

    /**
     * 得分
     */
    private Integer score;

    /**
     * 提交时间
     */
    private LocalDate submitTime;

}
