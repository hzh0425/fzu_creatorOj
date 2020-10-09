package com.moxi.xo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("auth_user_teacher")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AuthUserTeacher extends SuperEntity {

    private static final long serialVersionUID = 1L;



    private String usid;

    private String tid;


}
