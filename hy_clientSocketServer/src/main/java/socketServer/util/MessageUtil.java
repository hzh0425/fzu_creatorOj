package socketServer.util;

import com.alibaba.fastjson.JSON;
import com.moxi.utils.StringUtils;
import io.netty.channel.Channel;
import io.netty.channel.group.ChannelMatcher;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import socketServer.Application.EventDispatcher;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/30 21:25
 */
@Component
public class MessageUtil {

    @Autowired
    EventDispatcher dispatcher;



    public Channel getChannelByUserId(String userId){
        return dispatcher.getChannel(userId);
    }
    /**
     * 群发消息
     */
    public void sendMessageToGroup(ChannelMatcher matcher, Object message){
        doSendMessageGroup(message,matcher);
    }
    /**
     * 单发消息
     */
    public void sendMessageToSingle(Channel channel,Object message){
        doSendMessage(message,channel);
    }


    public void doSendMessage(Object  message, Channel channel){
        if(channel == null)return;
        if(message == null)return;
        TextWebSocketFrame frame=doBuildSocketFrame(message);
        channel.writeAndFlush(frame);
    }

    public void doSendMessage(String message,Channel channel){
        if(channel == null)return;
        TextWebSocketFrame frame=doBuildSocketFrame(message);
        channel.writeAndFlush(frame);
    }

    public void doSendMessageGroup(Object message,ChannelMatcher matcher){
        if(matcher == null)return;
        if(message == null)return;
        TextWebSocketFrame frame=doBuildSocketFrame(message);
        EventDispatcher.globalChannels.writeAndFlush(frame,matcher);
    }

    public <T> T doParseMessage(String message, Class<T> c){
        return JSON.parseObject(message,c);
    }

    public TextWebSocketFrame doBuildSocketFrame(String message){
        return new TextWebSocketFrame(message);
    }

    public TextWebSocketFrame doBuildSocketFrame(Object message){
        return new TextWebSocketFrame(JSON.toJSONString(message));
    }

}
