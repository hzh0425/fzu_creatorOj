package com.moxi.exam.restApi;

import com.moxi.exam.Application.OptionApplication;
import com.moxi.exam.Application.ProgramApplication;
import com.moxi.utils.RedisUtil;
import com.moxi.xo.global.SysConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/11/3 20:50
 */
@RestController
public class test {
    @Autowired
    ProgramApplication programApplication;
    @Autowired
    OptionApplication optionApplication;
    @Autowired
    RedisUtil redisUtil;
    @GetMapping("/test")
    public List getList(@RequestParam("examId")String examId,@RequestParam("stuId")String stuId,@RequestParam("type")int type){
        String key=examId+ SysConf.FILE_COLON+stuId+SysConf.FILE_COLON+type;
        return optionApplication.getPage(key,examId,stuId,redisUtil);
    }
}
