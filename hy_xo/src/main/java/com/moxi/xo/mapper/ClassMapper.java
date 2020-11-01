package com.moxi.xo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
            "ON a1.cid=a2.uid \n" +
            "${ew.customSqlSegment}")
    public IPage<Class> getListByTeacherId(IPage<Class> page , @Param(Constants.WRAPPER) Wrapper<Class> wrapper);


    @Select(" SELECT c2.* FROM " +
            " class_stu c1 \n" +
            " JOIN " +
            " class c2 " +
            " ON c1.cid=c2.uid \n" +
            " ${ew.customSqlSegment} ")
    public IPage<Class> getListByStuId( IPage<Class>page ,@Param(Constants.WRAPPER) Wrapper<Class> wrapper);
}
