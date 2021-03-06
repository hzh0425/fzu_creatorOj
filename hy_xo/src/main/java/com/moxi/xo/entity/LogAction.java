package com.moxi.xo.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import com.moxi.codeBase.Interface.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzh
 * @since 2020-11-01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("log_action")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class LogAction extends SuperEntity {

    private static final long serialVersionUID = 1L;



    /**
     * 考试id号
     */
    private String examId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 行为描述
     */
    private String actionDesc;

    private String pictureIds;

    private Date actionTime;


}
