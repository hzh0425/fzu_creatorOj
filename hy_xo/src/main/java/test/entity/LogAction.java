package test.entity;

import java.time.LocalDateTime;
import java.util.Date;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date actionTime;


}
