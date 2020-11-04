package com.moxi.exam.Application;

import com.moxi.exam.Template.PageCall;
import com.moxi.utils.RedisUtil;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public  List getPage(String examId, String stuId , int type) throws ExecutionException, InterruptedException {
        Future< List > page= null;
        PageCall call= null;
        switch (type){
            case 1:{
                //选择题
                call=new PageCall( optionApplication , examId, stuId, type, redisUtil);
                page= executor.submit(call);
                break;
            }
            case 3:{
                //编程题
                call=new PageCall( programApplication, examId, stuId, type, redisUtil);
                page= executor.submit(call);
                break;
            }
        }
        return page != null? page.get() :null;
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
        switch ( type ){
            case 1:{
                runnable=new Runnable() {
                    @Override
                    public void run() {
                        optionApplication.submit( examId , stuId ,page);
                    };
                };
                break;
            }
            case 3:{
                runnable= new Runnable() {
                    @Override
                    public void run() {
                        programApplication.submit( examId, stuId , page);
                    }
                };
                break;
            }
        }
        if( runnable != null){
            executor.submit( runnable );
        }
    }




}
