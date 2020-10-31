package socketServer.message;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import socketServer.Application.CheckPointApplication;
import socketServer.model.PerResult;

import javax.annotation.Resource;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/25 23:35
 */
@Service
public class MessageReceiver {
    @Autowired
    CheckPointApplication checkPointApplication;

    @KafkaListener(topics = {"judgeResult"},groupId = "judgeServer")
    public void onMessage(String result){
        System.out.println("receive a message:");
        this.handlerCheckPoint(result);
    }

    /**
     * 处理新提交的请求
     */
    public void handlerCheckPoint(String check){
        checkPointApplication.handleEvent(check);
    }
}
