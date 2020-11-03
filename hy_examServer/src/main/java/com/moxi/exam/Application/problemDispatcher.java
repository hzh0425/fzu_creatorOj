package com.moxi.exam.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/11/3 20:13
 */
@Service
public class problemDispatcher {


    public static ThreadPoolExecutor executor;

    static {
        //初始化线程池
        executor=new ThreadPoolExecutor(
                20, //核心线程数量
                50,
                120,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                Executors.defaultThreadFactory(),
                new  ThreadPoolExecutor.AbortPolicy());
    }

    

}
