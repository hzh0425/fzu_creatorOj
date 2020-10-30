package socketServer.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import socketServer.Interface.ApplicationService;
import socketServer.util.MessageUtil;

/**提问处理器
 * @author hzh
 * @version 1.0
 * @date 2020/10/30 22:03
 */
@Component
public class QuestionApplication implements ApplicationService {
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
        return false;
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
