package com.moxi.xo.mapper;

import com.moxi.base.mapper.SuperMapper;
import com.moxi.xo.entity.GapBank;
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
public interface GapBankMapper extends SuperMapper<GapBank> {

    @Select("SELECT a2.* FROM exam_bank e1 \n" +
            "JOIN gap_bank a2 ON e1.bid=a2.uid \n" +
            "WHERE e1.eid=#{examId} ORDER BY e1.num ASC")
    public List<GapBank> getExamGapList(@Param("examId")String examId);
}
