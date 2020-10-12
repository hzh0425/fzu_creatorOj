package com.moxi.xo.entity;

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
 * @since 2020-10-09
 */
@TableName("class_stu")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class ClassStu extends SuperEntity {

    private static final long serialVersionUID = 1L;



    private String sid;

    private String cid;


}
