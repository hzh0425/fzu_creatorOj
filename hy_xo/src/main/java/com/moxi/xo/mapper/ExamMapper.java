package com.moxi.xo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;

import com.moxi.codeBase.Interface.SuperMapper;
import com.moxi.xo.entity.Class;
import com.moxi.xo.entity.Exam;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
public interface ExamMapper extends SuperMapper<Exam> {

    @Select(" SELECT c3.* FROM class_stu c1\n" +
            " JOIN class c2\n" +
            " ON c1.cid=c2.uid\n" +
            " JOIN exam c3\n" +
            " ON c2.uid=c3.class_id\n" +
            " ${ew.customSqlSegment} ")
    public IPage<Exam> getListByStuId( IPage<Exam>page , @Param(Constants.WRAPPER) Wrapper<Exam> wrapper );

}
