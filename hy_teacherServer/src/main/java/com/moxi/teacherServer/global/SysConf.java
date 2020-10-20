package com.moxi.teacherServer.global;

import com.moxi.base.global.BaseSysConf;

import java.util.ArrayList;
import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/12 14:23
 */
public class SysConf extends BaseSysConf {
    public final static String CLASS_GETLIST="/class/getList";
    public final static String CLASS_ADD="/class/add";
    public final static List<String> WHITE=new ArrayList<String>(){{
        add(CLASS_ADD);
        add(CLASS_GETLIST);
    }} ;
}
