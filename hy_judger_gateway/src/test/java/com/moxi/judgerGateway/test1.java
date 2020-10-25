package com.moxi.judgerGateway;

import com.moxi.judgerGateway.kafka.judgeTaskSender;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/25 15:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class test1 {
    @Autowired
    judgeTaskSender judgeTaskSender;
    @Test
    public void test(){
        judgeTaskSender.sendJudgeTask("aosdifjoasdf");
    }
}
