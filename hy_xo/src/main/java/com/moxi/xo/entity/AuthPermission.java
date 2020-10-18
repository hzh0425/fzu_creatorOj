package com.moxi.xo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.moxi.base.entity.SuperEntity;
import com.moxi.utils.StringUtils;
import com.moxi.xo.global.SysConf;
import lombok.*;
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
 * @since 2020-10-09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("auth_permission")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AuthPermission extends SuperEntity {

    private static final long serialVersionUID = 1L;

    private String resourceType;

    private String resourceId;

    private String operation_type;

    private String operand;

    private String ownerId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date  createDate;

    public String getResourceUrl(){
        StringBuilder sb=new StringBuilder();
        sb.append(resourceType+SysConf.FILE_SEGMEN+resourceId);
        if(StringUtils.isNotEmpty(operation_type)){
            sb.append(SysConf.FILE_SEGMEN+operation_type);
        }
        if(StringUtils.isNotEmpty(operand)){
            sb.append(SysConf.FILE_SEGMEN+operand);
        }
        return sb.toString();
    }
}
