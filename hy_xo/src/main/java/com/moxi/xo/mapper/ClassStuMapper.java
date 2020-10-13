package com.moxi.xo.mapper;

import com.moxi.base.mapper.SuperMapper;
import com.moxi.xo.entity.AuthStudent;
import com.moxi.xo.entity.ClassStu;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
public interface ClassStuMapper extends SuperMapper<ClassStu> {
    @Select("SELECT a2.* FROM \n" +
            "class_stu a1 JOIN auth_student a2\n" +
            "ON a1.sid=a2.uid\n" +
            "WHERE a1.cid=#{classId}")
    public List<AuthStudent> getStudentsByClassId(@Param("classId")String classId);
}
