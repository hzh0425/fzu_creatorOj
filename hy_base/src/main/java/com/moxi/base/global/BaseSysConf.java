package com.moxi.base.global;
import java.util.ArrayList;
import java.util.List;
/**
 * 常量的基类
 *
 */
public class BaseSysConf {


    public final static String ADMIN_UID = "adminUid";



    public final static String SUCCESS = "success";
    public final static String ERROR = "error";


    public final static String UID = "uid";
    public final static String PAGE_NAME = "pageName";




    // 文件分割符
    public final static String FILE_SEGMENTATION = ",";
    public final static String FILE_SEGMEN="/";



    // AOP相关
    public static final String AUTHOR = "author";

    public static final String BLOG_SORT_UID = "blogSortUid";
    public static final String TAG_UID = "tagUid";
    public static final String KEYWORDS = "keywords";
    public static final String MONTH_DATE = "monthDate";
    public static final String MODULE_UID = "moduleUid";
    public static final String OTHER_DATA = "otherData";
    public static final String COMMENT_VO = "commentVO";
    public static final String CONTENT = "content";
    public final static String DATA="data";


    //权限相关
    public final static String Authorization="Authorization";
    public final static String BEARER="bearer";
    public final static String CODE="code";

    public final static String RESOURCE_CLASS="class";
    public final static String RESOURCE_EXAM="exam";
    public final static String RESOURCE_PERMISSION_GROUP="permissionGroup";

    public final static String OPERATION_ADD="add";
    public final static String OPERATION_DELETE="delete";
    public final static String OPERATION_EDIT="edit";
    public final static String OPERATION_GET_LIST="getList";

    public final static String OPERAND_STU="stu";
    public final static String OPERAND_EXAM="exam";
    public final static String OPERAND_PERMISSION_GROUP="permissionGroup";

    public final static List<String> OPERATIONS=new ArrayList<String>(){{
        add(OPERATION_ADD);
        add(OPERATION_DELETE);
        add(OPERATION_EDIT);
        add(OPERATION_GET_LIST);
    }};
    public final static List<String> CLASS_OPERAND=new ArrayList<String>(){{
        add(OPERAND_STU);
        add(OPERAND_EXAM);
        add(OPERAND_PERMISSION_GROUP);
    }};
}
