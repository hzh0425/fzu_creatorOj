package socketServer.Interface;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.netty.channel.Channel;
import org.apache.poi.ss.formula.functions.T;


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
    public  void handleEvent(String message);

    /**
     * 保存记录,default是1.8特性,可以在接口中直接实现方法,子类无需实现
     * 该方法是将保存到Mysql的耗时操作保存到任务队列中,防止堵塞
     */
    public default   <T extends Model> void doSave(Channel channel, T t){
        if(channel != null){

            channel.eventLoop().execute(t :: insert);
        }
    }
}
