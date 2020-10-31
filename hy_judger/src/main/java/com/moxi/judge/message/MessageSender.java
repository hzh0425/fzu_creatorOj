package com.moxi.judge.message;

import com.alibaba.fastjson.JSON;
import com.moxi.xo.entity.CheckPoints;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/29 14:43
 */
@Service
public class MessageSender {
    @Resource
    KafkaTemplate<String,String> messageTemplate;
    //单点评判回传
    public void sendMessage(String result){
        messageTemplate.send("judgeResult",result);
    }
}
