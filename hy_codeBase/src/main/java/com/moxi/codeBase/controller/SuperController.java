package com.moxi.codeBase.controller;

import com.moxi.codeBase.Exception.MyException;
import com.moxi.codeBase.Enums.HttpCode;
import com.moxi.codeBase.Result.Response;
import com.moxi.codeBase.Enums.SysConf;

/**
 * Controller基类
 *
 * @author xuzhixiang
 * @date 2017年9月30日18:12:56
 */
public class SuperController {
    public static <T> Response OK(String message, T data){
        return new Response(HttpCode.OK,message,data);
    }

    public static <T> Response UPDATE_OK( T data){

        return new Response(HttpCode.OK, SysConf.UPDATE_SUCCESS,data);
    }
    public static <T> Response CREATE_OK( T data){
        return new Response(HttpCode.OK, SysConf.INSERT_SUCCESS,data);
    }
    public static <T> Response DELETE_OK( T data){

        return new Response(HttpCode.OK, SysConf.DELETE_SUCCESS,data);
    }

    public static <T> Response GET_OK( T data){
        return new Response(HttpCode.OK , SysConf.GET_SUCCESS ,data);
    }

    public static <T> Response UPDATE_ERROR(String message){
        return new Response(HttpCode.NOT_FOUND, message,null);
    }
    public static <T> Response CREATE_ERROR(String message){
        return new Response(HttpCode.BAD_REQUEST, message , null );
    }
    public static <T> Response DELETE_ERROR( String message){
        return new Response(HttpCode.BAD_REQUEST, message  ,null);
    }

    public static <T> Response GET_ERROR(String message){
        return new Response(HttpCode.BAD_REQUEST , message ,null);
    }

    public static <T> Response ERROR(String message,T data){
        return new Response(HttpCode.BAD_REQUEST,message,data);
    }

    public static <T> Response ErrorWithCode(int code,String message,T data){
        return new Response(code,message,data);
    }

    public void Throw(String message){
        throw new MyException(message);
    }
}
