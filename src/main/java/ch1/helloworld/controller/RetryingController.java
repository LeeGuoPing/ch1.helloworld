package ch1.helloworld.controller;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * guava 重试机制
 *
 * @author liguoping
 * @date 2020/4/24 14:28
 */
@Slf4j
@RestController
@RequestMapping("/retrying")
public class RetryingController {

    @GetMapping("/case1")
    public Object t1() {

        // 定义一个任务
        Callable callable = () -> {
            log.info("call................");
//            throw new IOException("甘霖娘");
            return 2;
        };

        Retryer<Object> retryer = RetryerBuilder.newBuilder()
                // 等于null重试
                .retryIfResult(Predicates.isNull())
                // 等于2重试
                .retryIfResult(Predicates.equalTo(2))
                // 出现IOException 异常重试
                .retryIfExceptionOfType(IOException.class)
                // 一共重试三次
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                // 每一次执行的间隔, 2秒钟再试第二次
                .withWaitStrategy(WaitStrategies.fixedWait(2, TimeUnit.SECONDS))
                .build();
        try {
            retryer.call(callable);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (RetryException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
