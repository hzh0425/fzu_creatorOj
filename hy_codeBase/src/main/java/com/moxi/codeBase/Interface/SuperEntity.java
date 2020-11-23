package com.moxi.codeBase.Interface;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;


/**
 * Entity基类
 *
 * @author xuzhixiang
 * @date 2018年9月17日09:47:12
 */
@Data
@SuppressWarnings("rawtypes")
public class SuperEntity<T extends Model> extends Model {

    /**
     *
     */
    private static final long serialVersionUID = -4851055162892178225L;

    /**
     * 唯一UID
     */
    @TableId(value = "uid", type = IdType.UUID)
    private String uid;

}