package com.moxi.codeBase.vo;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * BaseVO   view object 表现层 基类对象
 *
 */

/**
 * @author hzh
 * @since 2020-08-07
 */
@Data
public class BaseVO<T> extends PageInfo<T> {

    /**
     * 唯一UID
     */

    @ApiModelProperty(value = "uuid")
    private String uid;


}
