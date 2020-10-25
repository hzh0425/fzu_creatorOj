package com.moxi.judgerGateway.web;

import com.moxi.judgerGateway.kafka.judgeTaskSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/25 18:21
 */
@RestController
public class test {
    @Autowired
    judgeTaskSender sender;
    @RequestMapping("/test")
    public String test(){
        sender.sendJudgeTask("judge | 1");
        return "success";
    }
}
