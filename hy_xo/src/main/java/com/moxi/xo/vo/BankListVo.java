package com.moxi.xo.vo;


import com.moxi.codeBase.validator.group.GetList;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotBlank;
import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/14 15:52
 */
@ApiModel(description = "题库接收类")
@Data
public class BankListVo {
    @ApiModelProperty(value = "考试的id")
    @NotBlank(groups = {GetList.class})
    private String examId;

    @ApiModelProperty(value = "题目的id")
    private String bankId;

    @ApiModelProperty(value = "编程类型")
    private int problemType;

    @ApiModelProperty(value = "编程题库")
    private List<examBankVo> bankVoList;

}
