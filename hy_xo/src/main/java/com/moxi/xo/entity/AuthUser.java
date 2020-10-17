package com.moxi.xo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.moxi.base.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.util.List;;
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
@AllArgsConstructor
@NoArgsConstructor
@TableName("auth_user")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AuthUser extends SuperEntity<AuthUser> {

    private static final long serialVersionUID = 1L;



    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户电话号码
     */
    private String phone;

    /**
     * 用户密码
     */
    private String passWord;

    /**
     * 用户名称
     */
    private String nickName;

    /**
     * 用户性别
     */
    private Integer gender;

    /**
     * 用户的头像url
     */
    private String avatar;

    /**
     * 自我描述
     */
    private String selfDesc;

    /**
     * 该用户是否起作用
     */
    private Integer valid;

    /**
     *  1-学生,2-教师,3-管理员
     */
    private int userType;
    /**
     * 创造时间
     */
    private LocalDate createDate;

    /**
     * 修改时间
     */
    private LocalDate updateDate;

    @TableField(exist = false)
    private List<AuthRole> roleList;




}
