package com.moxi.xo.mapper;

import com.moxi.base.mapper.SuperMapper;
import com.moxi.xo.entity.OptionBank;
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
public interface OptionBankMapper extends SuperMapper<OptionBank> {

    @Select("SELECT a2.* FROM exam_bank e1 \n" +
            "JOIN option_bank a2 ON e1.bid=a2.uid \n" +
            "WHERE e1.eid=#{examId} ORDER BY e1.num ASC")
    public List<OptionBank> getExamOptionList(@Param("examId")String examId);


    @Select("SELECT e2.* FROM \n" +
            "exam_bank e1 \n" +
            "JOIN option_bank e2\n" +
            "ON e1.bid=e2.uid \n" +
            "WHERE e1.eid=#{examId} \n" +
            "AND e1.type=1")
    public List<OptionBank> getExamOptionListForStu(@Param("examId")String examId);
}
