package socketServer.Application;

import com.alibaba.fastjson.JSONObject;
import com.moxi.utils.RedisUtil;
import io.netty.channel.Channel;
import io.netty.util.AttributeKey;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socketServer.Interface.ApplicationService;
import socketServer.Interface.DispatcherService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/31 0:00
 */
@Service
public class EventDispatcher implements DispatcherService {
    /**
     * 定义特性
     */
    public final static AttributeKey<String> USER_ID=AttributeKey.valueOf("userId");
    public final static AttributeKey<String> EXAM_ID=AttributeKey.valueOf("examId");
    public final static AttributeKey<JSONObject> ATTRS=AttributeKey.valueOf("attrs");
    /**
     * 依赖注入
     */
    @Autowired
    SubmitApplication submitApplication;
    @Autowired
    QuestionApplication questionApplication;
    @Autowired
    MonitorApplication monitorApplication;
    @Autowired
    CheckPointApplication checkPointApplication;
    @Autowired
    RedisUtil redisUtil;

    private List<ApplicationService> chains;

    /**
     * 构建事件处理责任链
     */
    @PostConstruct
    public void init(){
        chains=new ArrayList<ApplicationService>(){{
            add(submitApplication);
        }};
    }

    /**
     * 处理事件,责任链设计模式
     *
     * @param event
     */
    @Override
    public void handler(String event) {
        for(ApplicationService application:chains){
            if(application.supportEvent(event)){
                application.handleEvent(event);
                break;
            }else{
                System.out.println("it is not support");
            }
        }
    }

    /**
     * 注册channel
     *
     * @param channel
     */
    @Override
    public void register(Channel channel) {

    }

    /**
     * 增加attributes
     *
     * @param channel
     * @param key
     * @param value
     */
    @Override
    public void setAttrs(Channel channel, String key, Object value) {
        if(!channel.hasAttr(ATTRS)){
            channel.attr(ATTRS).set(new JSONObject());
        }else{
            JSONObject object=channel.attr(ATTRS).get();
            object.put(key,value);
            channel.attr(ATTRS).set(object);
        }
    }

    /**
     * 获取attributes
     *
     * @param channel
     */
    @Override
    public JSONObject getAttrs(Channel channel) {
        if(channel.hasAttr(ATTRS)){
            return channel.attr(ATTRS).get();
        }else{
            return null;
        }
    }

    /**
     * 获取attribute
     *
     * @param channel
     * @param key
     */
    @Override
    public Object getAttr(Channel channel, AttributeKey<T> key) {
        if(channel.hasAttr(key)){
            return channel.attr(key).get();
        }else{
            return null;
        }
    }
}
