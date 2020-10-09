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
@TableName("auth_user_role")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AuthUserRole extends SuperEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 管理员Id
     */
    private String usid;

    /**
     * 权限组id
     */
    private String rid;


}
