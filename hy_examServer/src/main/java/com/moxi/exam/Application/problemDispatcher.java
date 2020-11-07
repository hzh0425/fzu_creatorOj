package com.moxi.exam.Application;

import com.moxi.exam.Template.PageCall;
import com.moxi.exam.Template.problemApplication;
import com.moxi.utils.RedisUtil;
import com.moxi.xo.global.SysConf;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/11/3 20:13
 */
@Service
public class problemDispatcher {

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    ProgramApplication programApplication;
    @Autowired
    GapFillApplication gapFillApplication;
    @Autowired
    OptionApplication optionApplication;

    private  List<problemApplication>  chains;


    public static ThreadPoolExecutor executor;

    static {
        //初始化线程池
        executor=new ThreadPoolExecutor(
                2, //核心线程数量
                5,
                120,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                Executors.defaultThreadFactory(),
                new  ThreadPoolExecutor.AbortPolicy());
    }

    @PostConstruct
    public void init(){
        this.chains=new ArrayList<problemApplication>(){{
            add( optionApplication );
            add( gapFillApplication );
            add( programApplication );
        }};
    }


    public  List getPage(String examId, String stuId , int type) throws ExecutionException, InterruptedException {
        Future< List > page= null;
        String key= examId + SysConf.FILE_COLON + stuId + SysConf.FILE_COLON + type;

        for( problemApplication application : chains ){
            if( application.support( type ) ){
                page = executor.submit(() -> application.getPage( key ,examId, stuId, redisUtil ));
            }
        }
        return page.get();
    }

    /**
     * 提交题目
     * @param examId
     * @param stuId
     * @param page
     * @param <T>
     */
    public <T> void submit(String examId, String stuId, List<T> page ,int type){
        Runnable runnable=null;
        String key= examId + SysConf.FILE_COLON + stuId + SysConf.FILE_COLON + type;

        for( problemApplication application : chains ){
            if(application.support( type )){
                runnable= () -> application.submit( key,examId ,stuId , page);
            }
        }

        if( runnable != null){
            executor.submit( runnable );
        }
    }




}
