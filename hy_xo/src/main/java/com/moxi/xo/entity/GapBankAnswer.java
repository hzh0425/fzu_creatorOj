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
public class GapBankAnswer extends SuperEntity {

    private static final long serialVersionUID = 1L;



    /**
     * 填空题id
     */
    private String gid;

    /**
     * 答案id
     */
    private String aid;


}
