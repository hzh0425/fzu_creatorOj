package com.moxi.xo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.moxi.base.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Date;

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
@TableName("auth_permission")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AuthPermission extends SuperEntity {

    private static final long serialVersionUID = 1L;



    /**
     * 权限url
     */
    private String url;

    /**
     * 请求方法(get,post,delete等)
     */
    private String method;

    /**
     * 资源创建者uid
     */
    private String ownerId;

    /**
     * 该权限是否起作用
     */
    private Integer valid;

    /**
     * 创造时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;


}
