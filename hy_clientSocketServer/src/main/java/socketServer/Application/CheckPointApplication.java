package socketServer.Application;

import com.alibaba.fastjson.JSON;
import com.moxi.utils.RedisUtil;
import com.moxi.xo.entity.CheckPoints;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import socketServer.Interface.ApplicationService;
import socketServer.util.MessageUtil;

/**
 * 测评点回传器
 * @author hzh
 * @version 1.0
 * @date 2020/10/30 21:34
 */
@Component
public class CheckPointApplication implements ApplicationService {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    MessageUtil messageUtil;
    /**
     * 是否支持该事件
     *
     * @param message
     * @return
     */
    @Override
    public boolean supportEvent(String message) {
        return true;
    }

    /**
     * 处理事件
     *
     * @param message
     */
    @Override
    public void handleEvent(String message) {
        CheckPoints points= JSON.parseObject(message,CheckPoints.class);
        System.out.println("get a message:"+points);
        String userId=points.getUserId();
        Channel userChannel=EventDispatcher.globalChannelMap.get(userId);
        System.out.println(userId);
        System.out.println(userChannel);
        if(userChannel!=null){
            System.out.println("begin to send ");
            messageUtil.sendWebsocketFrame(message,userChannel);
            System.out.println("send done");
        }
    }
}
