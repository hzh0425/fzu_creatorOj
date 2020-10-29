package com.moxi.xo.entity;

import com.moxi.base.entity.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDate;

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
public class SubmitSelect extends SuperEntity {

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
