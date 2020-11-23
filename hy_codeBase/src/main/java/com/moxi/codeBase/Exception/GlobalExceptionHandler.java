package com.moxi.codeBase.Exception;

import com.moxi.codeBase.Result.Response;
import com.moxi.codeBase.controller.SuperController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import java.io.IOException;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/11/14 21:46
 */
//@ControllerAdvice
public class GlobalExceptionHandler extends SuperController {

    @ExceptionHandler(value =NullPointerException.class)
    @ResponseBody
    public Response exceptionNullHandler(Exception e){
        return ERROR("服务器发生了未知错误,请重新尝试",null);
    }

    @ExceptionHandler(value = IOException.class)
    @ResponseBody
    public Response exceptionIOExceptionHandler(Exception e){
        return ERROR("服务器发生了未知错误,请重新尝试",null);
    }


    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Response handlerMyException(MyException e){
        return ERROR(e.getMessage(),null);
    }
}
