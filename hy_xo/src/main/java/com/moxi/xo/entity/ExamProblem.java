package com.moxi.xo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/11/3 0:32
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExamProblem {
    private String examId;
    //考试信息
    private Exam exam;
    //选择题列表
    private List<OptionBank> optionBanks;
    //填空题列表
    public List<GapBank> gapBanks;
    //编程题列表
    private List<ProgramBank> programBanks;
}
