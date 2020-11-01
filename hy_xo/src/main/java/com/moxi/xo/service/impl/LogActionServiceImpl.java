package com.moxi.xo.service.impl;

import com.moxi.base.serviceImpl.SuperServiceImpl;
import com.moxi.xo.service.LogActionService;
import org.springframework.stereotype.Service;
import test.entity.LogAction;
import test.mapper.LogActionMapper;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzh
 * @since 2020-11-01
 */
@Service
public class LogActionServiceImpl extends SuperServiceImpl<LogActionMapper, LogAction> implements LogActionService {

}
