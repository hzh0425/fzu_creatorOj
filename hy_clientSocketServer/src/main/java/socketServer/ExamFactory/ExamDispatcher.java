package socketServer.ExamFactory;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Service;
import socketServer.Interface.ExamDispatcherService;

import java.util.List;
import java.util.concurrent.*;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/11/3 0:54
 */
@Service
public class ExamDispatcher implements ExamDispatcherService {
    public static ThreadPoolExecutor executor;

    static {
        //初始化线程池
        executor=new ThreadPoolExecutor(
                20, //核心线程数量
                50,
                120,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100),
                Executors.defaultThreadFactory(),
                new  ThreadPoolExecutor.AbortPolicy());
    }
    /**
     * 评分
     */
    @Override
    public <T> void score() {

    }

    /**
     * 提交问题
     *
     * @param problemList
     * @param type
     */
    @Override
    public <T> void submit(List<T> problemList, int type) {

    }

    /**
     * 获取问题列表
     *
     * @param examId
     * @param stuId
     * @return
     */
    @Override
    public <T> IPage<T> getProblem(String examId, String stuId) {
        return null;
    }
}
