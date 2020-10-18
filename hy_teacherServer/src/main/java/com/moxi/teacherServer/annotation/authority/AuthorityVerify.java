package com.moxi.teacherServer.annotation.authority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/7 17:26
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthorityVerify {
    String resourceType() default "";
    String operationType() default "";
    String operand() default "";
}
