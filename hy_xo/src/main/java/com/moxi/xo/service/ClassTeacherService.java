package com.moxi.xo.service;


import com.moxi.codeBase.Interface.SuperService;
import com.moxi.xo.entity.ClassTeacher;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
public interface ClassTeacherService extends SuperService<ClassTeacher> {
    public void deleteBatchByClassId(String classId);
}
