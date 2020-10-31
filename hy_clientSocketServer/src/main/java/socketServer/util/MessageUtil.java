package socketServer.util;

import com.alibaba.fastjson.JSON;
import io.netty.channel.Channel;
import org.springframework.stereotype.Component;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/30 21:25
 */
@Component
public class MessageUtil {
    public void sendMessage(Object message, Channel channel){
        channel.writeAndFlush(JSON.toJSONString(message));
    }
    public <T> T parseMessage(String message,Class<T> c){
    return JSON.parseObject(message,c);
    }
}
