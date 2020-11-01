package test.service.impl;

import test.entity.LogPicture;
import test.mapper.LogPictureMapper;
import test.service.LogPictureService;
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
public class LogPictureServiceImpl extends SuperServiceImpl<LogPictureMapper, LogPicture> implements LogPictureService {

}
