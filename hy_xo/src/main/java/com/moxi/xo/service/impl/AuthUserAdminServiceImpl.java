package com.moxi.xo.service.impl;


import com.moxi.codeBase.Interface.SuperServiceImpl;
import com.moxi.xo.mapper.AuthUserAdminMapper;
import com.moxi.xo.service.AuthUserAdminService;
import com.moxi.xo.entity.AuthUserAdmin;
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
public class AuthUserAdminServiceImpl extends SuperServiceImpl<AuthUserAdminMapper, AuthUserAdmin> implements AuthUserAdminService {

}
