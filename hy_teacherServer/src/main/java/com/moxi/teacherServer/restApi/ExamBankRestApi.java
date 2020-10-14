package com.moxi.teacherServer.restApi;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/14 15:07
 */
@RestController
@RequestMapping("/teacher/examBank")
@Api(value = "考试的题目相关接口", tags = {"考试的题目相关接口"})
public class ExamBankRestApi {
}
