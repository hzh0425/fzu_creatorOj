package com.moxi.teacherServer.annotation.permissionLog;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/16 0:02
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface permissionLogVerify {
    String resourceType() default "";
    String[] operationType() default {};
    String[]  operand() default {};
}



