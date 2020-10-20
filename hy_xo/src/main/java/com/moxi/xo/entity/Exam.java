package com.moxi.xo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.moxi.base.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;
import java.time.LocalDate;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("exam")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Exam extends SuperEntity {

    private static final long serialVersionUID = 1L;



    private String classId;
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


    private Date createDate;

    /**
     * 发布者
     */
    private String publisher;


    @TableField(exist = false)
    private List<ExamBank> examBankList;

    public Exam(String classId,String examName, Date startTime, Date endTime, String publisher) {

        this.classId=classId;
        this.examName = examName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.publisher = publisher;
        this.createDate=new Date();
    }

    public void UpdateExam(String examName, Date startTime, Date endTime) {

        this.examName = examName;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
