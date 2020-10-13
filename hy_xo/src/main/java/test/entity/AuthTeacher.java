package test.entity;

import com.moxi.base.entity.SuperEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hzh
 * @since 2020-10-12
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class AuthTeacher extends SuperEntity {

    private static final long serialVersionUID = 1L;



    /**
     * 教师所在学校
     */
    private String teacherSchool;

    /**
     * 教师身份
     */
    private String teacherIdentify;


}
