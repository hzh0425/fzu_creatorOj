package com.moxi.xo.vo;

import com.moxi.codeBase.validator.annotion.NotBlank;
import com.moxi.codeBase.validator.group.AddBatch;
import com.moxi.codeBase.validator.group.Delete;
import com.moxi.codeBase.validator.group.Insert;
import com.moxi.codeBase.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/12 14:19
 */
@Data
@ApiModel("班级接受类")
public class ClassVo extends BaseVO {





    @ApiModelProperty(value = "教师的id")
    @NotBlank(groups = {Insert.class})
    private String teacherId;

    /**
     * 班级名称
     */
    @ApiModelProperty(value = "班级名称")
    @NotBlank(groups = {Insert.class})
    private String className;

    /**
     * 班级描述
     */
    @ApiModelProperty(value = "班级描述")
    private String classDesc;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "班级创建者(教师的名字)")
    @NotBlank(groups = {Insert.class})
    private String creator;





}
