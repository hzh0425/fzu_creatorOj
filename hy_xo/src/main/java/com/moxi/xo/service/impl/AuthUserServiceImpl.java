package com.moxi.xo.service.impl;

import com.moxi.base.serviceImpl.SuperServiceImpl;
import com.moxi.xo.entity.AuthUser;
import com.moxi.xo.mapper.AuthUserMapper;
import com.moxi.xo.service.AuthUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
@Service
public class AuthUserServiceImpl extends SuperServiceImpl<AuthUserMapper, AuthUser> implements AuthUserService {

}
