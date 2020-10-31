package com.moxi.judge.Application;

import com.alibaba.fastjson.JSON;
import com.moxi.judge.message.MessageReceiver;
import com.moxi.judge.message.MessageSender;
import com.moxi.utils.RedisUtil;
import com.moxi.xo.entity.CheckPoints;
import com.moxi.xo.entity.SubmitProgram;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/25 23:52
 */
@Service
public class ApplicationDispatcher {
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    MessageSender sender;
    public void newSubmissionHandler(String  submissionKey) throws InterruptedException {
        System.out.println("receive a new submitTask,begin to resolve:"+submissionKey);
        Random random=new Random();
        //获取submission
        SubmitProgram program=(SubmitProgram) redisUtil.get(submissionKey);
        System.out.println(program);
        //假设每两秒钟发送一次check_point:
        int cnt=10;
        while(cnt-->0){
            System.out.println("发送消息:");
            CheckPoints points=new CheckPoints(program.getUid(),random.nextInt(),random.nextDouble()*10,"qwerqewr","asdfff",program.getUserId());
            sender.sendMessage(JSON.toJSONString(points));
            Thread.sleep(500);
        }
    }
}
