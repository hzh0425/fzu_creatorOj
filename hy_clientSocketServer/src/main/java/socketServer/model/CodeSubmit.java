package socketServer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/30 21:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeSubmit {
    private String eventType;
    /**
     * 用户id
     */
    private String userId;

    /**
     * 考试的id
     */
    private String examId;

    /**
     * 考试的题库id
     */
    private String bankId;

    /**
     * 语言
     */
    private String language;

    /**
     * 提交的代码
     */
    private String submitCode;

}
