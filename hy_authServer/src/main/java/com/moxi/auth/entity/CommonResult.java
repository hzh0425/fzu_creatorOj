package com.moxi.auth.entity;

import lombok.Data;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/17 0:30
 */
@Data
public class CommonResult<T>{
    private long code;
    private String message;
    private T data;

    public CommonResult(long code,String message,T t){
        this.code=code;
        this.message=message;
        this.data=t;
    }

}
