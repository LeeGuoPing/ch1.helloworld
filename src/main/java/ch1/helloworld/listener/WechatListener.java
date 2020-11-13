package ch1.helloworld.listener;

import ch1.helloworld.event.PayEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 短信监听器
 *
 * @author liguoping
 * @since 2020/11/13 14:18
 */
@Async
@Component
public class WechatListener implements ApplicationListener<PayEvent> {

    @Override
    public void onApplicationEvent(PayEvent payEvent) {
        Map<String, String> bodyMap = payEvent.getBodyMap();
        String topic = payEvent.getTopic();
        // 发送短信
//        System.out.println(1/0);
        System.out.println("订阅主题是:"+ topic + ", 发送公众号消息:"+ bodyMap.get("msg"));
    }
}
