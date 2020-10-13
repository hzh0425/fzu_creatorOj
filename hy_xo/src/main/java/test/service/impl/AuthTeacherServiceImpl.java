package test.service.impl;

import test.entity.AuthTeacher;
import test.mapper.AuthTeacherMapper;
import test.service.AuthTeacherService;
import com.moxi.base.serviceImpl.SuperServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzh
 * @since 2020-10-12
 */
@Service
public class AuthTeacherServiceImpl extends SuperServiceImpl<AuthTeacherMapper, AuthTeacher> implements AuthTeacherService {

}
