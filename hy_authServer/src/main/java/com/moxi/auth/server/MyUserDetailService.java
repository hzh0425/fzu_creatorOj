package com.moxi.auth.server;


import com.moxi.xo.entity.AuthPermission;
import com.moxi.xo.entity.AuthRole;
import com.moxi.xo.entity.AuthUser;
import com.moxi.xo.mapper.AuthUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/5 14:58
 *
 * 根据用户名查询用户权限--//应换成用户uid
 */
@Service
public class MyUserDetailService implements UserDetailsService {

    @Resource
    AuthUserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser=userMapper.loadUserByEmail(username);
        Set<GrantedAuthority> grantedAuthorities=new HashSet<>();
        for(AuthRole role:authUser.getRoleList()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            for (AuthPermission permission : role.getPermissionList()) {
                GrantedAuthority authority = new SimpleGrantedAuthority(permission.getUrl());
                grantedAuthorities.add(authority);
            }
        }
        // 可用性 :true:可用 false:不可用
        boolean enabled = true;
        // 过期性 :true:没过期 false:过期
        boolean accountNonExpired = true;
        // 有效性 :true:凭证有效 false:凭证无效
        boolean credentialsNonExpired = true;
        // 锁定性 :true:未锁定 false:已锁定
        boolean accountNonLocked = true;

        User user = new User(username,authUser.getPassWord(),
                enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuthorities);
        return user;

    }

}
