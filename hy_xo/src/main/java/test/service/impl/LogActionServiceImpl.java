package test.service.impl;

import test.entity.LogAction;
import test.mapper.LogActionMapper;
import test.service.LogActionService;
import com.moxi.base.serviceImpl.SuperServiceImpl;
import org.springframework.stereotype.Service;

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
