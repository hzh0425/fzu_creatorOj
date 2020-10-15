package com.moxi.base.vo;


import com.moxi.base.validator.annotion.IdValid;
import com.moxi.base.validator.annotion.NotBlank;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

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
