package com.moxi.xo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;

import com.moxi.codeBase.Interface.SuperMapper;
import com.moxi.xo.entity.AuthStudent;
import com.moxi.xo.entity.Class;
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

}
