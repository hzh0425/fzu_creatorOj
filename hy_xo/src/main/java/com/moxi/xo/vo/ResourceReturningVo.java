package com.moxi.xo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/16 0:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("增加资源类型的统一返回体")
public class ResourceReturningVo {

    @ApiModelProperty(value = "资源创建者的id")
    private String ownerId;


    @ApiModelProperty(value = "通知")
    private String message;

    @ApiModelProperty("资源Id")
    private String resourceId;

    @ApiModelProperty(value = "资源类型")
    private String resourceType;
}
