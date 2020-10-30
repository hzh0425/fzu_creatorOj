package socketServer.Interface;

import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import org.apache.poi.ss.formula.functions.T;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/31 0:03
 */
public interface MainEventService {
    /**
     * 处理事件
     * @param event
     */
    public void handler(String event);
    /**
     * 注册channel
     */
    public void register(Channel channel);
    /**
     * 增加attributes
     */
    public void setAttrs(Channel channel,String key,Object value);
    /**
     * 获取attributes
     */
    public JSONObject getAttrs(Channel channel);
    /**
     * 获取attribute
     */
    public Object getAttr(Channel channel, AttributeKey<T> key);

}
