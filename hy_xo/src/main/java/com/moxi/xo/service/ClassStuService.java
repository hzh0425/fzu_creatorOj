package com.moxi.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.moxi.base.service.SuperService;
import com.moxi.xo.entity.AuthStudent;
import com.moxi.xo.entity.ClassStu;
import com.moxi.xo.vo.ClassStuVo;

import java.util.List;;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
public interface ClassStuService extends SuperService<ClassStu> {
    public void deleteBatchByClassId(String classId);

    public IPage<AuthStudent> getList(ClassStuVo classId);

    public String add(ClassStuVo vo);

    public String deleteBatch(ClassStuVo vo);



    public String addFromExists(ClassStuVo vo);

    public String addBatch(ClassStuVo vo);
}
