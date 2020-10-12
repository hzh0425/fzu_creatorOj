package com.moxi.xo.mapper;

import com.moxi.base.mapper.SuperMapper;
import com.moxi.xo.entity.Class;
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
public interface ClassMapper extends SuperMapper<Class> {
    @Select("SELECT a2.* \n" +
            "FROM class_teacher a1 JOIN class a2\n" +
            "ON a1.cid=a2.uid\n" +
            "WHERE a1.tid=#{teacherId} AND a2.valid=1;")
    public List<Class> getListByTeacherId(@Param("teacherId")String teacherId);
}
