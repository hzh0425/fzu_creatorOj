package com.moxi.exam.restApi;

import com.moxi.exam.Application.OptionApplication;
import com.moxi.exam.Application.ProgramApplication;
import com.moxi.exam.Application.problemDispatcher;
import com.moxi.utils.RedisUtil;
import com.moxi.xo.global.SysConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/11/3 20:50
 */
@RestController
public class test {
    @Autowired
    com.moxi.exam.Application.problemDispatcher problemDispatcher;
    @GetMapping("/test")
    public List getList(@RequestParam("examId")String examId,@RequestParam("stuId")String stuId,@RequestParam("type")int type) throws ExecutionException, InterruptedException {
        return problemDispatcher.getPage(examId,stuId,type);
    }

    @GetMapping("/test1")
    public String test(@RequestParam("examId")String examId,@RequestParam("stuId")String stuId,@RequestParam("type")int type) throws ExecutionException, InterruptedException {
        return "suasdf";
    }
}
