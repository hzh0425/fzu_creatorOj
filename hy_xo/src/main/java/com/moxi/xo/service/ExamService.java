package com.moxi.xo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.moxi.base.service.SuperService;
import com.moxi.xo.entity.Exam;
import com.moxi.xo.vo.ExamVo;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
public interface ExamService extends SuperService<Exam> {

    public IPage<Exam> getList(ExamVo vo);

    public String add(ExamVo vo);

    public String delete(String eid);

    public String edit(ExamVo vo);
}
