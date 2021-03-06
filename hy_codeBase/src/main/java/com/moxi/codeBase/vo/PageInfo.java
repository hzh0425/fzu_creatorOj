package com.moxi.codeBase.vo;

import com.moxi.codeBase.validator.Messages;
import com.moxi.codeBase.validator.annotion.LongNotNull;
import com.moxi.codeBase.validator.group.GetList;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * PageVO  用于分页
 *
 */

/**
 * @author hzh
 * @since 2020-08-07
 */
@Data
public class PageInfo<T> {

    /**
     * 关键字
     */
    @ApiModelProperty(value = "搜索关键字",required = false)
    private String keyword;

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页面")
    @LongNotNull(groups = {GetList.class}, message = Messages.PAGE_NOT_NULL)
    private Long currentPage;

    /**
     * 页大小
     */
    @ApiModelProperty(value = "页面的大小")
    @LongNotNull(groups = {GetList.class}, message = Messages.SIZE_NOT_NULL)
    private Long pageSize;
}
