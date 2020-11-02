package socketServer.restApi;

import com.moxi.utils.ResultUtil;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.service.ExamService;
import com.moxi.xo.vo.StuExamVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/11/1 11:35
 */
@RestController
@Api(value = "3.题目api",tags = {"3.题目api"})
@RequestMapping("/stu/problem")
public class problemRestApi {
    @Autowired
    private ExamService examService;

    @ApiOperation(value = "获取考试列表,默认传回选择题", notes = "获取考试列表,默认传回选择题", response = String.class)
    @GetMapping("/getList/{examId}")
    public String getList( @PathVariable String examId ) {
        return ResultUtil.result(SysConf.SUCCESS,"" );
    }

    @ApiOperation(value = "获取选择列表", notes = "获取选择列表", response = String.class)
    @PostMapping("/getList/select")
    public String getSelect( @RequestBody StuExamVo vo ) {
        return ResultUtil.result(SysConf.SUCCESS, "" );
    }

    @ApiOperation(value = "获取填空列表", notes = "获取填空列表", response = String.class)
    @PostMapping("/getList/fill")
    public String getFill( @RequestBody StuExamVo vo ) {
        return ResultUtil.result(SysConf.SUCCESS, "" );
    }


    @ApiOperation(value = "获取编程题列表,只返回题目及uid", notes = "获取编程题列表,只返回题目及uid", response = String.class)
    @PostMapping("/getList/program")
    public String getProgram( @RequestBody StuExamVo vo ) {
        return ResultUtil.result(SysConf.SUCCESS, "" );
    }


    @ApiOperation(value = "根据id获取编程题具体得题目", notes = "根据id获取编程题具体得题目", response = String.class)
    @PostMapping("/getList/programById")
    public String getProgramById( @RequestBody StuExamVo vo ) {
        return ResultUtil.result(SysConf.SUCCESS, "" );
    }


    @ApiOperation(value = "提交选择题", notes = "提交选择题", response = String.class)
    @PostMapping("/submit/select")
    public String submitSelect( @RequestBody StuExamVo vo ) {
        return ResultUtil.result(SysConf.SUCCESS, "" );
    }

    @ApiOperation(value = "提交填空", notes = "提交填空", response = String.class)
    @PostMapping("/submit/fill")
    public String submitFill( @RequestBody StuExamVo vo ) {
        return ResultUtil.result(SysConf.SUCCESS, "" );
    }
}
