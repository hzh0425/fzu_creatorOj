package socketServer.Application;

import com.moxi.base.enums.EStatus;
import com.vladsch.flexmark.ast.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import socketServer.Interface.ApplicationService;
import socketServer.global.SysConf;
import socketServer.message.MessageSender;
import socketServer.model.CodeSubmit;
import socketServer.util.MessageUtil;

import java.util.UUID;

/**
 * 代码提交处理器
 * @author hzh
 * @version 1.0
 * @date 2020/10/30 21:33
 */
@Component
public class SubmitApplication implements ApplicationService {


    @Autowired
    MessageUtil messageUtil;
    @Autowired
    MessageSender messageSender;
    /**
     * 是否支持该事件
     *
     * @param message
     * @return
     */
    @Override
    public boolean supportEvent(String message) {
        return message.contains(SysConf.EVENT_SUBMIT);
    }

    /**
     * 处理事件
     *
     * @param message
     */
    @Override
    public void handleEvent(String message) {
        CodeSubmit submit= messageUtil.parseMessage(message, CodeSubmit.class);
        System.out.println(submit);
        if(submit!=null){
            //将代码缓存到redis,key: uuid,value:CodeSubmit
            String uuid= UUID.randomUUID().toString();
            //发送到评测队列
            messageSender.sendMessage(uuid);
            System.out.println("send done"+uuid);
        }
    }
}
