package socketServer.Application;

import com.alibaba.fastjson.JSON;
import com.moxi.utils.StringUtils;
import com.moxi.xo.entity.ExamQuiz;
import io.netty.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import socketServer.Interface.ApplicationService;
import socketServer.global.SysConf;
import socketServer.matcher.examMatcher;
import socketServer.util.MessageUtil;

/**提问处理器---ok
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
        return message.contains(SysConf.EVENT_QUESTION);
    }

    /**
     * 处理事件
     *
     * @param message
     */
    @Override
    public void handleEvent(String message) {
        ExamQuiz quiz = JSON.parseObject(message,ExamQuiz.class);
        if(
                StringUtils.isEmpty(quiz.getUserFrom())
                || StringUtils.isEmpty(quiz.getUserTo())
                || StringUtils.isEmpty(quiz.getSendType())
        ){
            return;
        }
        String type = quiz.getSendType();
        Channel channel=messageUtil.getChannelByUserId( quiz.getUserFrom() );
        if(channel == null) return;
        switch (type){
            case SysConf.QUIZ_GROUP : {
                doHandleGroup(quiz);
                break;
            }
            case SysConf.QUIZ_SINGLE : {
                doHandleSingle(quiz);
                break;
            }
        }

        //保存到mysql
        doSave( channel,quiz );
    }

    public void doHandleGroup(ExamQuiz quiz){
        if(StringUtils.isNotEmpty(quiz.getExamId())){
            examMatcher matcher= new examMatcher(quiz.getExamId());
            messageUtil.sendMessageToGroup(matcher , quiz);
        }
    }
    public void doHandleSingle(ExamQuiz quiz){
        Channel toChannel = messageUtil.getChannelByUserId(quiz.getUserTo());
        System.out.println(toChannel);
        if(toChannel != null){
            messageUtil.sendMessageToSingle(toChannel,quiz);
        }
    }
}
