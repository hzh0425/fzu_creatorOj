package com.moxi.xo.mapper;

import com.moxi.base.mapper.SuperMapper;
import com.moxi.xo.entity.ProgramBank;
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
}
