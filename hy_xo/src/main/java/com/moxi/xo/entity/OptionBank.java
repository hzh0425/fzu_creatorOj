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
public class OptionBank extends SuperEntity {

    private static final long serialVersionUID = 1L;



    /**
     * 题目名称
     */
    private String name;

    /**
     * 题目题目/描述
     */
    private String optionTitle;

    /**
     * 1-单选题,2-多选题,3,判断题
     */
    private Integer optionType;

    /**
     * 发布者
     */
    private String publisher;

    /**
     * 该资源是否起作用
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
