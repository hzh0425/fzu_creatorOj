package com.moxi.xo.vo;

import com.moxi.base.vo.BaseVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/21 16:36
 */
@Data
public class PermissionGroupVo extends BaseVO<PermissionGroupVo> {
    /**
     * 角色名
     */
    @ApiModelProperty(value = "组名")
    private String groupName;

    /**
     * 角色描述
     */
    @ApiModelProperty(value = "组描述")
    private String groupDesc;

    /**
     * 类型
     */
    @ApiModelProperty(value = "组的类别,1代表班级相关权限组,2代表管理员端权限组")
    private Integer groupType;

    @ApiModelProperty(value = "如果是1类别的权限组,需要带上classId")
    private String classId;

    @ApiModelProperty(value = "权限id,多个则以,划分")
    private String permissionIds;

}
