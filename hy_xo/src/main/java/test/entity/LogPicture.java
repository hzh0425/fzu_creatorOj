package test.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.TableName;
import com.moxi.base.entity.SuperEntity;
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
 * @since 2020-11-01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("log_picture")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class LogPicture extends SuperEntity {

    private static final long serialVersionUID = 1L;


    /**
     * 图像路径
     */
    private String pictureUrl;

    /**
     * 描述
     */
    private String pictureDesc;

    private LocalDateTime createTime;


}
