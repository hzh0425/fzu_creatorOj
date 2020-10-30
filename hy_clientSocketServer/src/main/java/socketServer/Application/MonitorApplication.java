package socketServer.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import socketServer.Interface.ApplicationService;
import socketServer.global.SysConf;
import socketServer.util.MessageUtil;

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

    }
}
