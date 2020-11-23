package com.moxi.xo.vo;

import com.moxi.codeBase.validator.annotion.NotBlank;
import com.moxi.codeBase.validator.group.AddBatch;
import com.moxi.codeBase.validator.group.Delete;
import com.moxi.codeBase.validator.group.Insert;
import com.moxi.codeBase.vo.BaseVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/11/1 11:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuExamVo extends BaseVO {
    public String stuId;
}
