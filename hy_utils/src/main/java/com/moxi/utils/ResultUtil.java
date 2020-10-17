package com.moxi.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回统一接口
 *
 * @author xzx19950624@qq.com
 * 2018年9月9日19:22:20
 */

public class ResultUtil {
    /**
     */
    public static String result(Object code, Object data) {
        Map<Object, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("data", data);
        return JsonUtils.objectToJson(map);
    }
    public static String resultWithData(Object code, Object Message,Object data){
        Map<Object, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("message", Message);
        map.put("data",data);
        return JsonUtils.objectToJson(map);
    }


}
