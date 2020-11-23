package com.moxi.xo.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.moxi.codeBase.validator.annotion.NotBlank;
import com.moxi.codeBase.validator.group.AddBatch;
import com.moxi.codeBase.validator.group.Delete;
import com.moxi.codeBase.validator.group.Insert;
import com.moxi.codeBase.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/14 14:17
 */
@Data
@ApiModel("考试 接受类")
public class ExamVo extends BaseVO<ExamVo> {

    @ApiModelProperty(value = "teacherId")
    @NotBlank(groups = { Insert.class})
    private String tid;
    /**
     * 考试名
     */
    @ApiModelProperty(value = "考试名称")
    private String examName;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "开始时间,格式:yyyy-MM-dd HH:mm:ss")
    private Date startTime;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "结束时间,格式:yyyy-MM-dd HH:mm:ss")
    private Date endTime;

    /**
     * 发布者
     */
    @ApiModelProperty(value = "发布者姓名,如 王姥姥")
    private String publisher;

    @ApiModelProperty(value = "考试题目集")
    private List<examBankVo> examBankVoList;

}
