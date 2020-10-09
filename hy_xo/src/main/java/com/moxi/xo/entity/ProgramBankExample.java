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
public class ProgramBankExample extends SuperEntity {

    private static final long serialVersionUID = 1L;



    /**
     * 编程题id
     */
    private String pid;

    /**
     * 答案id
     */
    private String eid;


}
