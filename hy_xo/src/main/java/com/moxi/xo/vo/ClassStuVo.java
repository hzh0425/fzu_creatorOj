package com.moxi.xo.vo;

import com.moxi.base.validator.annotion.NotBlank;
import com.moxi.base.validator.group.AddBatch;
import com.moxi.base.validator.group.Delete;
import com.moxi.base.validator.group.Insert;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/12 19:25
 */
@Data
public class ClassStuVo {

    private MultipartFile file;

    @NotBlank(groups = {Insert.class, Delete.class})
    private String sid;

    @NotBlank(groups = {Insert.class,AddBatch.class})
    private String cid;

    @NotBlank(groups = {AddBatch.class})
    private List<StuVo> stuList;
}
