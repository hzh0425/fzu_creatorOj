package com.moxi.xo.mapper;

import com.alibaba.nacos.common.util.UuidUtils;
import com.moxi.base.mapper.SuperMapper;
import com.moxi.xo.entity.AuthStudent;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.UUID;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/12 19:37
 */
public interface AuthStudentMapper extends SuperMapper<AuthStudent> {
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
