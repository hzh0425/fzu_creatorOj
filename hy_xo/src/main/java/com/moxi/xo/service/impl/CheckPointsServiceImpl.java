package com.moxi.xo.service.impl;

import com.moxi.base.serviceImpl.SuperServiceImpl;
import com.moxi.xo.service.CheckPointsService;
import org.springframework.stereotype.Service;
import test.entity.CheckPoints;
import test.mapper.CheckPointsMapper;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzh
 * @since 2020-10-29
 */
@Service
public class CheckPointsServiceImpl extends SuperServiceImpl<CheckPointsMapper, CheckPoints> implements CheckPointsService {

}
