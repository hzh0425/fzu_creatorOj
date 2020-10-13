package com.moxi.xo.service.impl;

import com.moxi.base.serviceImpl.SuperServiceImpl;
import com.moxi.xo.entity.AuthStudent;
import com.moxi.xo.mapper.AuthStudentMapper;
import com.moxi.xo.service.AuthStudentService;
import org.springframework.stereotype.Service;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/12 19:37
 */
@Service
public class AuthStudentServiceImpl extends SuperServiceImpl<AuthStudentMapper, AuthStudent> implements AuthStudentService {
}
