package com.moxi.xo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/13 17:12
 */
@Data
@ApiModel("学生信息接收类")
public class StuVo {
    @ApiModelProperty(value = "姓名")
    private String stuName;
    @ApiModelProperty(value = "学号")
    private String stuNum;
    @ApiModelProperty(value = "学校")
    private String stuSchool;
    @ApiModelProperty(value = "专业")
    private String stuMajor;
    @ApiModelProperty(value = "年级")
    private String stuGrade;
    @ApiModelProperty(value = "班级")
    private String stuClass;
}
