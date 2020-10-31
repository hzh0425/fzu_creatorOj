package socketServer.Interface;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import org.apache.poi.ss.formula.functions.T;

import java.util.Map;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/31 0:03
 */
public interface DispatcherService {
    /**
     * 处理事件
     * @param event
     */
    public void handler(String event);

    /**
     * 注册channel
     */
    public void register(Channel channel, Map<String,String> attrs);
    /**
     * 注销channel
     */
    public void deregister(Channel channel);
    /**
     * 根据Key获取channel
     */
    public  Channel getChannel(String key);
    /**
     * 增加attributes
     */
    public <T> void setAttr(Channel channel, AttributeKey<T> key, T value);

    /**
     * 获取attribute
     */
    public  <T> T getAttr(Channel channel, AttributeKey<T> key);

}
