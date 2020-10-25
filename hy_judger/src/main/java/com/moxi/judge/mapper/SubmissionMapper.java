package com.moxi.judge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.moxi.judge.model.Submission;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/25 23:34
 */
@Mapper
public interface SubmissionMapper extends BaseMapper<Submission> {
}
