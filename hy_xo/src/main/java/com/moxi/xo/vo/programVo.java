package com.moxi.xo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/11/3 20:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class programVo {


    private String uid;
    /**
     * 题目的题目/描述
     */
    private String questionTitle;
}
