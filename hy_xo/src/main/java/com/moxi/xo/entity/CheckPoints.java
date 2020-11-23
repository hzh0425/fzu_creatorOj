package com.moxi.xo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import com.moxi.codeBase.Interface.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
@TableName("check_points")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class CheckPoints extends SuperEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 提交表的id
     */
    private String submitId;

    /**
     * 是否符合
     */
    private Integer checkMatch;

    /**
     * 该点的分数
     */
    private Double checkScore;

    private String checkInput;

    private String checkOutput;


    @TableField(exist = false)
    private String userId;

}
