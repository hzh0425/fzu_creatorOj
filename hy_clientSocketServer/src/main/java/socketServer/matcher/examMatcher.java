package socketServer.matcher;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelMatcher;
import socketServer.Application.EventDispatcher;

/**channel 匹配,获取该班级的所有channel
 * @author hzh
 * @version 1.0
 * @date 2020/10/31 23:29
 */
public class examMatcher implements ChannelMatcher {
    private String examId;

    public examMatcher(String examId){
        this.examId=examId;
    }

    @Override
    public boolean matches(Channel channel) {
        return channel.attr(EventDispatcher.EXAM_ID).get().equals(examId);
    }
}
