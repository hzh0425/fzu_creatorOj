package com.moxi.xo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.moxi.base.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;
import java.time.LocalDate;

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
@TableName("gap_bank")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class GapBank extends SuperEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 题目名称
     */
    private String name;

    /**
     * 题目题目/描述
     */
    private String questionTitle;

    /**
     * 题目编程内容
     */
    private String questionInfo;

    private String questionAnswer;
    /**
     * 发布者
     */
    private String publisher;

    /**
     * 该资源是否起作用
     */
    private Integer valid;

    /**
     * 创造时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;

    @TableField(exist = false)
    private List<GapAnswer> gapAnswerList;

    public GapBank(String name, String questionTitle, String questionInfo, String questionAnswer, String publisher, Integer valid, Date createDate, Date updateDate) {
        this.name = name;
        this.questionTitle = questionTitle;
        this.questionInfo = questionInfo;
        this.questionAnswer = questionAnswer;
        this.publisher = publisher;
        this.valid = valid;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public void UpdateGapBank(String name, String questionTitle, String questionInfo, String questionAnswer) {
        this.name = name;
        this.questionTitle = questionTitle;
        this.questionInfo = questionInfo;
        this.questionAnswer = questionAnswer;
        this.updateDate=new Date();
    }
}
