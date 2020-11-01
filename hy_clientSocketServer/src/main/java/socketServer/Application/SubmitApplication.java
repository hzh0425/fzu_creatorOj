package socketServer.Application;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.moxi.utils.RedisUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.entity.SubmitProgram;
import com.moxi.xo.vo.CodeSubmitVo;
import io.netty.channel.Channel;
import org.omg.CORBA.IDLType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import socketServer.Interface.ApplicationService;
import socketServer.global.SysConf;
import socketServer.message.MessageSender;
import socketServer.model.CodeSubmit;
import socketServer.util.MessageUtil;


import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 代码提交处理器
 * @author hzh
 * @version 1.0
 * @date 2020/10/30 21:33
 */
@Component
public class SubmitApplication implements ApplicationService {


    @Autowired
    MessageUtil messageUtil;
    @Autowired
    MessageSender messageSender;
    @Autowired
    RedisUtil redisUtil;
    /**
     * 是否支持该事件
     *
     * @param message
     * @return
     */
    @Override
    public boolean supportEvent(String message) {
        return message.contains(SysConf.EVENT_SUBMIT);
    }

    /**
     * 处理事件
     *
     * @param message
     */
    @Override
    public void handleEvent(String message) {
        CodeSubmitVo vo= doParse(message,CodeSubmitVo.class);

        if(vo == null)return;

        if(StringUtils.isEmpty( vo.getUserId() ))return;
        Channel channel= messageUtil.getChannelByUserId(vo.getUserId());
        if(channel == null)return;

        //构建提交记录
        SubmitProgram program=new SubmitProgram( vo );

        //将代码缓存到redis
        String key=buildKey( SysConf.EVENT_SUBMIT, program.getUid() );
        redisUtil.setEx( key, program, SysConf.RUNNING_UPPER, TimeUnit.MINUTES);

        //发送到评测队列
        messageSender.sendMessage( key );
        System.out.println("send done"+key);

        //保存到mysql
        doSave( channel, program);

    }


    public String buildKey(String event,String id){
        StringBuilder sb=new StringBuilder();
        sb.append(event);
        sb.append(SysConf.FILE_COLON);
        sb.append(id);
        return sb.toString();
    }
}
