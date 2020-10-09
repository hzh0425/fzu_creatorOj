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
public class OptionAnswer extends SuperEntity {

    private static final long serialVersionUID = 1L;



    /**
     * A,B,C,D 若有多个,就用,划分
     */
    private String optionAnswer;


}
