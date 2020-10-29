package com.moxi.judge.message;

import com.alibaba.fastjson.JSON;
import com.moxi.judge.model.PerResult;
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
    public void sendMessagePerResult(String id){
        Random random=new Random();
        PerResult result= PerResult.builder()
                .judgeId(id)
                .curPoint(random.nextInt(11))
                .isOk(true)
                .score(random.nextFloat()*10)
                .build();
        sendMessage(JSON.toJSONString(result));
    }
    public void sendMessage(String result){
        messageTemplate.send("judgeResult",result);
    }
}
