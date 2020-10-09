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
public class ProgramExample extends SuperEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 示例数据
     */
    private String data;

    /**
     * 示例结果
     */
    private String result;


}
