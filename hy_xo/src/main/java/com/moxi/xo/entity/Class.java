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
public class Class extends SuperEntity {

    private static final long serialVersionUID = 1L;



    /**
     * 班级名称
     */
    private String className;

    /**
     * 班级描述
     */
    private String classDesc;

    /**
     * 班级人数
     */
    private Integer stuNum;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 该用户是否起作用
     */
    private Integer valid;

    /**
     * 创造时间
     */
    private LocalDate createDate;

    /**
     * 修改时间
     */
    private LocalDate updateDate;


}
