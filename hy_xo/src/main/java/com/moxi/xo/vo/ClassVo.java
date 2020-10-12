package com.moxi.xo.vo;

import com.moxi.base.validator.annotion.NotBlank;
import com.moxi.base.validator.group.Insert;
import lombok.Data;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/12 14:19
 */
@Data
public class ClassVo {


    @NotBlank(groups = {Update.class})
    private String uid;

    @NotBlank(groups = {Insert.class})
    private String teacherId;

    /**
     * 班级名称
     */
    @NotBlank(groups = {Insert.class})
    private String className;

    /**
     * 班级描述
     */
    private String classDesc;

    /**
     * 班级人数
     */
    private Integer stuNum;

    /**
     * 创建者
     */
    @NotBlank(groups = {Insert.class})
    private String creator;

    /**
     * 该用户是否起作用
     */
    private Integer valid;

    /**
     * 创造时间
     */
    private LocalDate createDate;

    /**
     * 修改时间
     */
    private LocalDate updateDate;

}
