package com.moxi.xo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/29 21:47
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramExample {
    private static final long serialVersionUID = 1L;

    /**
     * 示例数据
     */
    private String data;

    /**
     * 示例结果
     */
    private String result;
}
