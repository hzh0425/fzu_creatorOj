package com.moxi.xo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.moxi.base.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
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
@TableName("program_bank")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ProgramBank extends SuperEntity {

    private static final long serialVersionUID = 1L;



    /**
     * 题目的题目/描述
     */
    private String questionTitle;

    /**
     * 题目内容
     */
    private String questionContent;

    /**
     * 题目示例
     */
    private String questionExample;
    /**
     * 题目时间上限
     */
    private Integer upperTime;

    /**
     * 题目内存上限
     */
    private Integer upperMemory;

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
    private List<ProgramExample> exampleList;

    public ProgramBank(String questionTitle, String questionContent, String questionExample, Integer upperTime, Integer upperMemory, String publisher, Integer valid, Date createDate, Date updateDate) {
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionExample = questionExample;
        this.upperTime = upperTime;
        this.upperMemory = upperMemory;
        this.publisher = publisher;
        this.valid = valid;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public void UpdateProgramBank(String questionTitle, String questionContent, String questionExample, Integer upperTime, Integer upperMemory, Integer valid) {
        this.questionTitle = questionTitle;
        this.questionContent = questionContent;
        this.questionExample = questionExample;
        this.upperTime = upperTime;
        this.upperMemory = upperMemory;
        this.valid = valid;
        this.updateDate=new Date();
    }
}
