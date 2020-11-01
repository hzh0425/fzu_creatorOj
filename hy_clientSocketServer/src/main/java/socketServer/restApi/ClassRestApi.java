package socketServer.restApi;

import com.moxi.utils.ResultUtil;
import com.moxi.xo.global.SysConf;
import com.moxi.xo.service.ClassService;
import com.moxi.xo.service.ExamService;
import com.moxi.xo.vo.StuExamVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return ResultUtil.result(SysConf.SUCCESS, classService.getListForStu(vo) );
    }

    @ApiOperation(value = "加入班级", notes = "加入班级", response = String.class)
    @GetMapping("/add")
    public String add(@RequestParam("stuId") String stuId,
                      @RequestParam("classId") String classId
    ){
        return classService.stuAddClass(stuId,classId);
    }

    @ApiOperation(value = "退出班级", notes = "退出班级", response = String.class)
    @GetMapping("/exit")
    public String exit(@RequestParam("stuId") String stuId,
                      @RequestParam("classId") String classId
    ){
        return classService.stuRemoveClass(stuId,classId);
    }
}
