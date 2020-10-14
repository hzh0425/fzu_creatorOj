package com.moxi.xo.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.moxi.base.validator.annotion.NotBlank;
import com.moxi.base.validator.group.GetList;
import com.moxi.base.vo.BaseVO;
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
public class ExamVo extends BaseVO<ExamVo> {

    @NotBlank(groups = {GetList.class})
    private String tid;
    /**
     * 考试名
     */
    private String examName;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date startTime;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date endTime;

    /**
     * 发布者
     */
    private String publisher;

    private List<examBankVo> examBankVoList;

}
