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
public class OptionSelect {
    private static final long serialVersionUID = 1L;

    private String optionDesc;

    private int optionNum;

}
