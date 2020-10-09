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
public class ExamScore extends SuperEntity {

    private static final long serialVersionUID = 1L;


    private String eid;

    private String sid;

    /**
     * 选择题成绩
     */
    private Integer selectScore;

    /**
     * 填空题成绩
     */
    private Integer fillScore;

    /**
     * 编程题成绩
     */
    private Integer programScore;

    /**
     * 总成绩
     */
    private Integer sumScore;


}
