package socketServer.restApi;

import com.moxi.utils.ResultUtil;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.vo.StuExamVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/11/1 11:50
 */
@RestController
@Api(value = "4.排名api",tags = {"4.排名api"})
@RequestMapping("/stu/rank")
public class rankRestApi {
    
    @ApiOperation(value = "获取排名列表", notes = "获取排名列表", response = String.class)
    @PostMapping("/getList")
    public String getList( @RequestBody StuExamVo vo ) {
        return ResultUtil.result(SysConf.SUCCESS, "" );
    }
}
