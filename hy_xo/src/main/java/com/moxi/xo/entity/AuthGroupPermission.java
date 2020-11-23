package com.moxi.xo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.moxi.codeBase.Interface.SuperEntity;
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
@TableName("auth_group_permission")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AuthGroupPermission extends SuperEntity {

    private static final long serialVersionUID = 1L;



    /**
     * 角色id
     */
    private String rid;

    /**
     * 权限id
     */
    private String pid;


}
