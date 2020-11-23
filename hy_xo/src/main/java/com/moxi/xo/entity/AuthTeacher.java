package com.moxi.xo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.moxi.codeBase.Interface.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/12 19:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("auth_teacher")
public class AuthTeacher extends SuperEntity {
    private String teacherSchool;
    private String teacherIdentify;
}
