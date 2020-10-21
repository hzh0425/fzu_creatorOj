package com.moxi.auth;

import com.moxi.xo.entity.AuthPermission;
import com.moxi.xo.mapper.AuthPermissionMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/21 19:47
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class test1 {
    @Autowired
    AuthPermissionMapper mapper;
    @Test
    public void test1(){
        System.out.println(mapper.getPermissionsByOwnerId("qmks3f7e0616fe660d11d6d397e215b8c"));
    }
}
