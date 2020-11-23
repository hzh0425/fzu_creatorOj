package com.moxi.xo.mapper;


import com.moxi.codeBase.Interface.SuperMapper;
import com.moxi.xo.entity.ProgramBank;
import com.moxi.xo.vo.programVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hzh
 * @since 2020-10-09
 */
public interface ProgramBankMapper extends SuperMapper<ProgramBank> {

    @Select("SELECT a2.uid,a2.question_title FROM exam_bank e1 \n" +
            "JOIN program_bank a2 \n" +
            "ON e1.bid=a2.uid \n" +
            "WHERE e1.eid=#{examId} \n" +
            "ORDER BY e1.num ASC")
    public List<ProgramBank> getExamProgramList(@Param("examId")String examId);

    /**
     * 获取学生端编程题列表,默认返回title
     * @param examId
     * @return
     */
    @Select("SELECT e2.uid,e2.question_title FROM \n" +
            "exam_bank e1 \n" +
            "JOIN program_bank e2\n" +
            "ON e1.bid=e2.uid \n" +
            "WHERE e1.eid=#{examId} \n" +
            "AND e1.type=3")
    public List<programVo> getListForStu(@Param("examId")String examId);
}
