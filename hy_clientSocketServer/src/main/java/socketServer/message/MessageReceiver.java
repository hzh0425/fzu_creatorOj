package socketServer.message;

import com.alibaba.fastjson.JSON;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import socketServer.model.PerResult;

import javax.annotation.Resource;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/25 23:35
 */
@Service
public class MessageReceiver {



    @KafkaListener(topics = {"judgeResult"},groupId = "judgeServer")
    public void onMessage(String result){
        System.out.println("receive a message:");
        PerResult re= JSON.parseObject(result,PerResult.class);
        System.out.println(re);
    }

    /**
     * 处理新提交的请求
     */
    public void newSubmissionHandler(String submissionId){

    }
}
