package com.moxi.xo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.moxi.base.entity.SuperEntity;
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
@TableName("auth_student")
public class AuthStudent extends SuperEntity<AuthStudent> {
    private String stuName;
    private String stuNum;
    private String stuSchool;
    private String stuMajor;
    private String stuGrade;
    private String stuClass;
}
