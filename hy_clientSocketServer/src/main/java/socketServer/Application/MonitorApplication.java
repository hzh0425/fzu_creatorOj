package socketServer.Application;

import com.alibaba.fastjson.JSON;
import com.moxi.utils.StringUtils;
import com.moxi.xo.entity.LogAction;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import socketServer.Interface.ApplicationService;
import socketServer.global.SysConf;
import socketServer.util.MessageUtil;
import sun.rmi.runtime.Log;


import java.util.Date;
import java.util.UUID;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/30 21:33
 */
@Component
public class MonitorApplication implements ApplicationService {
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
        return message.contains(SysConf.EVENT_MONITOR);
    }

    /**
     * 处理事件
     *
     * @param message
     */
    @Override
    public void handleEvent(String message) {
        LogAction action=doParse(message , LogAction.class);
        if( action != null){
            action.setUid(UUID.randomUUID().toString());
            action.setActionTime(new Date());

            String stuID= action.getUserId();
            if(StringUtils.isEmpty( stuID ))return;
            Channel channel= messageUtil.getChannelByUserId( stuID );

            if(channel != null){
                messageUtil.doSendMessage( "警告!您已被检测到:"+action.getActionDesc(),channel);

                //保存到Mysql
                doSave(channel ,action);
            }
        }

    }
}
