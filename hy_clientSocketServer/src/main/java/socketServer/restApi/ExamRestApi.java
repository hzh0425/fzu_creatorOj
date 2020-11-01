package socketServer.restApi;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
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
 * @date 2020/11/1 11:18
 */
@RestController
@Api(value = "考试api",tags = {"1.考试api"})
@RequestMapping("/stu/exam")
public class ExamRestApi {
    @Autowired
    ExamService examService;

    @ApiOperation(value = "获取考试列表", notes = "获取考试列表", response = String.class)
    @ApiOperationSupport(ignoreParameters = {"uid"})
    @PostMapping("/getList")
    public String getList( @RequestBody StuExamVo vo ) {
        return ResultUtil.result(SysConf.SUCCESS, examService.getListForStu(vo) );
    }

}
