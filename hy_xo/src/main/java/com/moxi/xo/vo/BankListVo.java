package com.moxi.xo.vo;

import com.moxi.base.validator.annotion.NotBlank;
import com.moxi.base.validator.group.GetList;
import com.moxi.base.validator.group.Insert;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/14 15:52
 */
@Data
public class BankListVo {
    @NotBlank(groups = {GetList.class})
    private String examId;
    private String programId;
    private int problemType;
    private List<examBankVo> bankVoList;

}
