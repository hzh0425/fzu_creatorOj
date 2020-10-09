package com.moxi.xo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.moxi.base.entity.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.util.List;
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
@TableName("auth_role")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AuthRole extends SuperEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String roleDesc;

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
    
    @TableField(exist =  false)
    private List<AuthPermission> permissionList;

}
