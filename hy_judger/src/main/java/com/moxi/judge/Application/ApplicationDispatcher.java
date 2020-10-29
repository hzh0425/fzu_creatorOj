package com.moxi.judge.Application;

import com.moxi.judge.message.MessageReceiver;
import com.moxi.judge.message.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/25 23:52
 */
@Service
public class ApplicationDispatcher {
    @Autowired
    MessageSender sender;
    public void newSubmissionHandler(String  submissionId){
        System.out.println("receive a new submitTask,begin to resolve:"+submissionId);
        sender.sendMessagePerResult(submissionId);
    }
}
