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
 * @since 2020-10-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ResponseProgram extends SuperEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 考试id
     */
    private String eid;

    /**
     * 学生Id
     */
    private String sid;

    /**
     * 题目序号
     */
    private Integer num;

    /**
     * 程序答案
     */
    private String response;

    /**
     * 测评结果
     */
    private String result;

    /**
     * 总得分
     */
    private Integer score;

    /**
     * 提交时间
     */
    private LocalDate submitTime;


}
