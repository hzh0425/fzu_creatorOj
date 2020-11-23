package com.moxi.codeBase.Result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/11/6 0:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private  int code;
    private String message;
    private  T data;
}
