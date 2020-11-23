package com.moxi.xo.vo;


import com.moxi.codeBase.validator.annotion.NotBlank;
import com.moxi.codeBase.validator.group.AddBatch;
import com.moxi.codeBase.validator.group.Delete;
import com.moxi.codeBase.validator.group.Insert;
import com.moxi.codeBase.vo.BaseVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/12 19:25
 */
@Data
@ApiModel("班级学生 接受类")
public class ClassStuVo extends BaseVO<ClassStuVo> {

    @ApiModelProperty(value = "studentId,(student表的id,若有多个id,用(',')划分)")
    @NotBlank(groups = {Insert.class, Delete.class})
    private String sid;

    @ApiModelProperty(value = "classId")
    @NotBlank(groups = {Insert.class, AddBatch.class})
    private String cid;




    @ApiModelProperty(value = "学生列表")
    @NotBlank(groups = {AddBatch.class})
    private List<StuVo> stuList;
}
