package com.moxi.exam.Template;

import com.moxi.utils.RedisUtil;
import com.moxi.xo.global.SysConf;
import org.apache.poi.ss.formula.functions.T;


import java.util.concurrent.Callable;
import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/11/3 21:38
 */
public class PageCall implements Callable<List> {

    private problemApplication<T> application;
    private String examId;
    private String stuId;
    private int type;
    private RedisUtil redisUtil;

    public PageCall(problemApplication application, String examId, String stuId , int type, RedisUtil redisUtil) {
        this.application = application;
        this.examId = examId;
        this.stuId = stuId;
        this.type=type;
        this.redisUtil = redisUtil;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public List<T> call() throws Exception {
        String key= examId + SysConf.FILE_COLON + stuId + SysConf.FILE_COLON + type;
        return application.getPage( key ,examId, stuId, redisUtil);
    }
}
