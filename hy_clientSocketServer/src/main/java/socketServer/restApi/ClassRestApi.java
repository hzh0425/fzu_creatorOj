package socketServer.restApi;

import com.moxi.utils.ResultUtil;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.service.ClassService;
import com.moxi.xo.service.ExamService;
import com.moxi.xo.vo.StuExamVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/11/1 11:34
 */
@RestController
@Api(value = "2.班级api",tags = {"2.班级api"})
@RequestMapping("/stu/class")
public class ClassRestApi {
    @Autowired
    ClassService classService;

    @ApiOperation(value = "获取班级列表", notes = "获取班级列表", response = String.class)
    @PostMapping("/getList")
    public String getList( @RequestBody StuExamVo vo ) {
        return ResultUtil.result(SysConf.SUCCESS, "" );
    }

    @ApiOperation(value = "加入班级", notes = "加入班级", response = String.class)
    @PostMapping("/add")
    public String add( @RequestBody StuExamVo vo ) {
        return ResultUtil.result(SysConf.SUCCESS, "" );
    }
}
