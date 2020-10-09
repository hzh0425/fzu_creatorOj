package com.moxi.xo.entity;

import com.moxi.base.entity.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

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
public class ExamBank extends SuperEntity {

    private static final long serialVersionUID = 1L;


    /**
     * exam id
     */
    private String eid;

    /**
     * 题目id
     */
    private String bid;

    /**
     * 题目类型 1_选择,2_填空,3_编程
     */
    private Integer type;

    /**
     * 题目序号
     */
    private Integer num;

    /**
     * 题目分数
     */
    private Integer score;


}
