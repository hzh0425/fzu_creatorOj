package com.moxi.xo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.moxi.base.entity.SuperEntity;
import com.moxi.xo.vo.CodeSubmitVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

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
@TableName("submit_program")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SubmitProgram extends SuperEntity<SubmitProgram> {

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
     * 提交时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date submitTime;

    public SubmitProgram(CodeSubmitVo submitVo) {
        setUid(UUID.randomUUID().toString());
        this.userId = submitVo.getUserId();
        this.examId = submitVo.getExamId();
        this.bankId = submitVo.getBankId();
        this.submitCode = submitVo.getSubmitCode();
        this.language = submitVo.getLanguage();
        this.submitTime=new Date();
        this.judgeResult="wait";
    }

    /**
     * 提交的代码
     */
    private String submitCode;

    /**
     * 语言
     */
    private String language;
    /**
     * 运行开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date executeTime;

    /**
     * 运行用时
     */
    private Integer useTime;

    /**
     * 运行所用内存
     */
    private Integer useMemory;

    /**
     * 结果(ac,wr)
     */
    private String judgeResult;

    /**
     * 该题分数
     */
    private Double judgeScore;

    /**
     * 判题日志
     */
    private String judgeLog;





}
