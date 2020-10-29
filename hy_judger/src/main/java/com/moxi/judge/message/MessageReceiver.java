package com.moxi.judge.message;

import com.moxi.judge.Application.ApplicationDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/25 23:35
 */
@Service
public class MessageReceiver {

    @Autowired
    ApplicationDispatcher dispatcher;

    @KafkaListener(topics = {"judgeProblem"},groupId = "judgeGroup")
    public void onMessage(String submissionId){
        System.out.println("receive a message:"+submissionId);
        newSubmissionHandler(submissionId);
    }

    /**
     * 处理新提交的请求
     */
    public void newSubmissionHandler(String submissionId){
        dispatcher.newSubmissionHandler(submissionId);
    }


}
