package com.moxi.xo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.moxi.base.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
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
@AllArgsConstructor
@NoArgsConstructor
@TableName("auth_group")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AuthGroup extends SuperEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 角色名
     */
    private String groupName;

    /**
     * 角色描述
     */
    private String groupDesc;

    /**
     * 类型
     */
    private Integer groupType;

    private String classId;

    /**
     * 创造时间
     */
    private Date createDate;


    public void updateGroup(String groupName, String groupDesc) {
        this.groupName = groupName;
        this.groupDesc = groupDesc;
        this.updateDate=new Date();
    }

    /**
     * 修改时间
     */
    private Date updateDate;

    public AuthGroup(String groupName, String groupDesc, Integer groupType, String classId, Date createDate,Date updateDate) {
        this.groupName = groupName;
        this.groupDesc = groupDesc;
        this.groupType = groupType;
        this.classId = classId;
        this.updateDate=updateDate;
        this.createDate = createDate;
    }


    @TableField(exist =  false)
    private List<AuthPermission> permissionList;

}
