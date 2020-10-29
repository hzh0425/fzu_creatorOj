package com.moxi.xo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/29 21:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GapAnswer {
    private static final long serialVersionUID = 1L;



    private String fillAnswer;

    /**
     * 当前空格的位置,从1开始
     */
    private Integer fillNum;
}
