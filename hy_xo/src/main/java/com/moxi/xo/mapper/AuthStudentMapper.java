package com.moxi.xo.mapper;

import com.alibaba.nacos.common.util.UuidUtils;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.moxi.base.mapper.SuperMapper;
import com.moxi.xo.entity.AuthStudent;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.UUID;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/12 19:37
 */
public interface AuthStudentMapper extends SuperMapper<AuthStudent> {


    @Select("SELECT a2.* FROM \n" +
            "class_stu a1 JOIN auth_student a2\n" +
            "ON a1.sid=a2.uid \n" +
            "${ew.customSqlSegment}")
    public IPage<AuthStudent> getStudentsByClassId(IPage<AuthStudent> page, @Param(Constants.WRAPPER) Wrapper<AuthStudent> wrapper);


    /**
     * 主要是需要忽略含有重复的school-num unique key
     */
    @InsertProvider(type = AuthStudentProvider.class,method = "insertBatch")
    public void insertBatch(@Param("stuList")List<AuthStudent> stuList);


    public  class  AuthStudentProvider{
        public String insertBatch(@Param("stuList")List<AuthStudent> stuList){
            StringBuilder sb=new StringBuilder();
            sb.append("insert ignore into auth_student values ");
            for (int i = 0; i < stuList.size(); i++) {
                AuthStudent stu=stuList.get(i);
                sb.append("(");
                String uid= UuidUtils.generateUuid();
                sb.append("'"+uid+"',");
                sb.append("'"+stu.getStuName()+"',");
                sb.append("'"+stu.getStuNum()+"',");
                sb.append("'"+stu.getStuSchool()+"',");
                sb.append("'"+stu.getStuMajor()+"',");
                sb.append("'"+stu.getStuGrade()+"',");
                sb.append("'"+stu.getStuClass()+"',");
                sb.append("0)");
                if(i!=stuList.size()-1)sb.append(",");
            }
            return sb.toString();
        }
    }
}
