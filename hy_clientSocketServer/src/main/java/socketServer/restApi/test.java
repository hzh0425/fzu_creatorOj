package socketServer.restApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hzh
 * @version 1.0
 * @date 2020/10/8 21:35
 */
@RestController
@RequestMapping(value = "/socket")
public class test {
    @GetMapping(value = "/test")
    public String test1(){

        return "success";
    }
}
