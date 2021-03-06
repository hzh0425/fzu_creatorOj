package com.moxi.xo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/20 21:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestTemplate  {
    private int resourceId;
    private String resourceType;
    private String operand;
    private String operationType;
    private String resourceDesc;
    private String operandDesc;
}
