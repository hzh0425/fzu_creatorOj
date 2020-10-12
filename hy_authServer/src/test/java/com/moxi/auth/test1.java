package com.moxi.auth;


import com.moxi.xo.entity.AuthRole;
import com.moxi.xo.entity.AuthUser;
import com.moxi.xo.mapper.AuthRoleMapper;
import com.moxi.xo.mapper.AuthUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/5 15:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class test1 {

    @Autowired
    AuthRoleMapper roleMapper;
    @Autowired
    AuthUserMapper userMapper;
    @Test
    public void testAuth(){
        AuthUser user=userMapper.loadUserByEmail("642256541@qq.com");
        System.out.println(user);
        System.out.println("done");

    }
}
