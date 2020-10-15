package com.moxi.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.moxi.base.service.SuperService;
import com.moxi.xo.entity.Class;
import com.moxi.xo.vo.ClassVo;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
public interface ClassService extends SuperService<Class> {

    public IPage<Class> getList(ClassVo teacherId);

    public String add(ClassVo vo);

    public String edit(ClassVo vo);

    public String delete(String classId);
}
