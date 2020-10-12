package com.moxi.teacherServer;

import com.moxi.xo.service.ClassService;
import org.jetbrains.annotations.TestOnly;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/12 15:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class classTest {
    @Autowired
    ClassService classService;
    @Test
    public void test1(){

        System.out.println(classService.getList("qmks3f7e0616fe660d11d6d397e215b8c"));
    }
}
