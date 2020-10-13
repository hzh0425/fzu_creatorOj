package com.moxi.xo.entity;

import com.moxi.base.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class OptionSelect {

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
