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
public class OptionSelect extends SuperEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 选项描述
     */
    private String optionDesc;

    /**
     * A,B,C,D
     */
    private String optionNum;


}
