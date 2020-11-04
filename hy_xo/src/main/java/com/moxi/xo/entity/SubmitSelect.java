package com.moxi.xo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.moxi.base.entity.SuperEntity;
import com.moxi.base.enums.EProblemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzh
 * @since 2020-10-29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("submit_select")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SubmitSelect extends SuperEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 用户id
     */
    private String userId;

    /**
     * 考试的id
     */
    private String examId;

    /**
     * 考试的题库id
     */
    private String bankId;

    /**
     * 提交的答案,A,B,C,D
     */
    private String response;

    /**
     * 得分
     */
    private Integer score;

    /**
     * 提交时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date submitTime;

    private int status;

    public SubmitSelect(String stuId, String examId, OptionBank x) {
        this.userId=stuId;
        this.examId=examId;
        this.bankId=x.getUid();
        this.response=x.getQuestionAnswer();
        this.submitTime=new Date();
        this.score=0;
        this.status= EProblemStatus.IM_JUDGE;
    }
}
