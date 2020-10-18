package com.moxi.commons.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/17 14:12
 */
@Service
@FeignClient("oj-authServert")
public interface authFeign {
    @GetMapping(value = "/oauth/checkPermission")
    public String checkPermission(@RequestParam("token")String token, @RequestParam("url") String url);
}
