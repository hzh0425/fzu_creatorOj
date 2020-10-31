package socketServer.Application;

import com.alibaba.fastjson.JSONObject;
import com.moxi.utils.RedisUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.global.SysConf;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.ChannelMatcher;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import socketServer.Interface.ApplicationService;
import socketServer.Interface.DispatcherService;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/31 0:00
 */
@Service
public class EventDispatcher implements DispatcherService {
    public static DefaultChannelGroup globalChannels=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    public static ConcurrentHashMap<String,Channel> globalChannelMap=new ConcurrentHashMap<>();
    /**
     * 定义特性
     */
    public final static AttributeKey<String> USER_ID=AttributeKey.valueOf(SysConf.USER_ID);
    public final static AttributeKey<String> EXAM_ID=AttributeKey.valueOf(SysConf.EXAM_ID);
    public final static AttributeKey<String> USER_TYPE=AttributeKey.valueOf(SysConf.USER_TYPE);
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
            add(questionApplication);
            add(monitorApplication);
        }};
    }

    /**
     * 处理事件,责任链设计模式
     *
     * @param event
     */
    @Override
    public void handler(String event) {
        for(ApplicationService application : chains){
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
    public void register(Channel channel, Map<String,String> attrs) {
        String userId=attrs.getOrDefault(SysConf.USER_ID,"");
        String examId=attrs.getOrDefault(SysConf.EXAM_ID,"");
        String userType=attrs.getOrDefault(SysConf.USER_TYPE,"");
        setAttr(channel,USER_ID,userId);
        setAttr(channel,EXAM_ID,examId);
        setAttr(channel, USER_TYPE,userType);
        globalChannels.add(channel);
        globalChannelMap.put(userId,channel);
        System.out.println(userId);
        System.out.println(channel);
        System.out.println("register success");
    }
    /**
     * 注销channel
     */
    @Override
    public void deregister(Channel channel){
        globalChannels.remove(channel);
        String userId=getAttr(channel,USER_ID);
        if(StringUtils.isNotEmpty(userId)){
            globalChannelMap.remove(userId);
        }
    }
    /**
     * 根据Key获取channel
     */
    public  Channel getChannel(String key){
        return globalChannelMap.getOrDefault(key,null);
    }


    /**
     * 增加attributes
     *
     * @param channel
     * @param key
     * @param value
     */
    @Override
    public <T> void setAttr(Channel channel, AttributeKey<T> key, T value) {
        channel.attr(key).set(value);
    }



    /**
     * 获取attribute
     *
     * @param channel
     * @param key
     */
    @Override
    public <T> T getAttr(Channel channel, AttributeKey<T> key) {
        if(channel.hasAttr(key)){
            return channel.attr(key).get();
        }else{
            return null;
        }
    }
}
