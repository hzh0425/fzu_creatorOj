package com.moxi.xo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import com.moxi.codeBase.Interface.SuperEntity;
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
@TableName("option_bank")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class OptionBank extends SuperEntity {

    private static final long serialVersionUID = 1L;




    /**
     * 题目题目/描述
     */
    private String questionTitle;

    /**
     * 选项,json数组
     */
    private String questionSelect;
    /**
     * 1-单选题,2-多选题,3,判断题
     */
    private Integer optionType;

    /**
     * 题目答案
     */
    private String questionAnswer;
    /**
     * 发布者
     */
    private String publisher;

    private String publisherId;
    /**
     * 该资源是否起作用
     */
    private Integer shareMode;

    /**
     * 创造时间
     */
    private Date createDate;

    /**
     * 修改时间
     */
    private Date updateDate;



    public void UpdateOptionBank( String questionTitle, String questionSelect,String questionAnswer,int optionType,int shareMode) {
        this.questionTitle = questionTitle;
        this.questionSelect = questionSelect;
        this.questionAnswer=questionAnswer;
        this.optionType=optionType;
        this.shareMode=shareMode;
        this.updateDate=new Date();
    }

    @TableField(exist = false)
    private List<OptionSelect> selectList;


    public OptionBank(String questionTitle, String questionSelect, Integer optionType,String questionAnswer, String publisher,String publisherId, Integer share_mode, Date createDate, Date updateDate) {
        this.questionTitle = questionTitle;
        this.questionSelect = questionSelect;
        this.optionType = optionType;
        this.questionAnswer=questionAnswer;
        this.publisher = publisher;
        this.publisherId=publisherId;
        this.shareMode=share_mode;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }
}
