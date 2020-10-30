package socketServer.Interface;

/**处理器接口
 * @author hzh
 * @version 1.0
 * @date 2020/10/30 21:34
 */
public interface ApplicationService {
    /**
     * 是否支持该事件
     * @param message
     * @return
     */
    public boolean supportEvent(String message);
    /**
     * 处理事件
     */
    public void handleEvent(String message);
}
