package socketServer.Interface;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/11/3 0:50
 */
public interface ProblemService {

    /**
     * 为该类问题打分
     * @param problemList
     * @param <T>
     */
    public <T> void score(List<T> problemList, String stuId);

    /**
     * 获取该类问题列表
     * @param examId
     * @param <T>
     * @return
     */
    public <T> IPage<T> getProblem(String examId, String stuId);


    /**
     * 提交问题列表
     * @param problemList
     * @param stuId
     */
    public void submit(List<T> problemList,String stuId);
}
