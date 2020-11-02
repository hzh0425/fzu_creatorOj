package socketServer.Interface;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.poi.ss.formula.functions.T;
import java.util.List;
/**
 * @author hzh
 * @version 1.0
 * @date 2020/11/3 0:45
 */
public interface ExamDispatcherService {

    /**
     * 评分
     * @param <T>
     */
    public <T> void score();

    /**
     * 提交问题
     * @param problemList
     * @param type
     * @param <T>
     */
    public <T> void submit(List<T> problemList,int type);
    /**
     * 获取问题列表
     * @param examId
     * @param <T>
     * @return
     */
    public <T> IPage<T> getProblem(String examId,String stuId);


}
