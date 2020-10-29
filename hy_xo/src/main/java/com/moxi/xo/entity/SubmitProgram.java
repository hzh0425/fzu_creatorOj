package com.moxi.xo.entity;

import com.moxi.base.entity.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzh
 * @since 2020-10-29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SubmitProgram extends SuperEntity {

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
     * 提交时间
     */
    private LocalDateTime submitTime;

    /**
     * 提交的代码
     */
    private String submitCode;

    /**
     * 运行开始时间
     */
    private LocalDateTime executeTime;

    /**
     * 运行用时
     */
    private Integer useTime;

    /**
     * 运行所用内存
     */
    private Integer useMemory;

    /**
     * 结果(ac,wr)
     */
    private String judgeResult;

    /**
     * 该题分数
     */
    private Double judgeScore;

    /**
     * 判题日志
     */
    private String judgeLog;


}
