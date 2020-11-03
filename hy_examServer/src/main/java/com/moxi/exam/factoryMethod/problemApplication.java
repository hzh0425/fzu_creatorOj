package com.moxi.exam.factoryMethod;
import com.moxi.utils.RedisUtil;
import com.moxi.utils.StringUtils;
import com.moxi.xo.entity.OptionBank;
import com.moxi.xo.global.SysConf;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/11/3 20:10
 */

public abstract class problemApplication<T> {



    /**
     * 获取题目集列表
     * @param
     * @return
     */
    public List<T> getPage(String key,String examId,String stuId ,RedisUtil redisUtil){

        if(StringUtils.isEmpty( examId )||StringUtils.isEmpty( stuId ))return null;


        List<T> redisPage= getPageFromRedis( key , redisUtil);


        if( redisPage != null ){
            System.out.println("get from redis");
            return redisPage;
        }

        List<T> mysqlPage=getPageFromMysql( examId, stuId );

        System.out.println("get from mysql");

        if( mysqlPage != null ){

            savePageToRedis( key, mysqlPage , redisUtil );
        }

        return mysqlPage;
    }

    /**
     * 从mysql 获取数据
     * @return
     */
    public abstract List<T> getPageFromMysql(String examId,String stuId);

    /**
     * 从redis获取数据
     * @return
     */
    public  List<T>  getPageFromRedis(String key , RedisUtil redisUtil){
        if(redisUtil.hasKey(key)){
            Set<T> set= redisUtil.sMembers( key );
            return new ArrayList<>(set);
        }
        return null;
    }

    /**
     * save to redis
     */
    public  void savePageToRedis(String key, List<T> page, RedisUtil redisUtil){
        redisUtil.sAddList( key ,page);
    }


    /**
     * 评分
     * @param <T>
     */
    public abstract <T> void score();

    /**
     * 统计分析
     * @param <T>
     */
    public abstract <T> void analyze();
}
