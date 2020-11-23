package com.moxi.xo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.moxi.codeBase.Interface.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/29 20:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("submit_fill")
public class SubmitFill extends SuperEntity {

    private static final long serialVersionUID = 1L;



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
