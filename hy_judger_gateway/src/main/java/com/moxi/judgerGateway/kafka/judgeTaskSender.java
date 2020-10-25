package com.moxi.judgerGateway.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/25 15:38
 */
@Service
public class judgeTaskSender {
    @Resource
    private KafkaTemplate<String,String> kafkaTemplate;
    public void sendJudgeTask(String taskId){
        kafkaTemplate.send("judgeProblem",taskId);
        System.out.println("send done"+taskId);
    }
}
