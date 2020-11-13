package ch1.helloworld.event;

import org.springframework.context.ApplicationEvent;

import java.util.Map;

/**
 * 支付的事件
 *
 * @author liguoping
 * @since 2020/11/13 14:10
 */
public class PayEvent extends ApplicationEvent {

    /**
     * 消息体
     */
    private Map<String, String> bodyMap;

    /**
     * 订阅主题
     */
    private String topic;

    public PayEvent(Object source, Map<String,String> bodyMap, String topic) {
        super(source);
        this.bodyMap = bodyMap;
        this.topic = topic;
    }

    public Map<String, String> getBodyMap() {
        return bodyMap;
    }

    public void setBodyMap(Map<String, String> bodyMap) {
        this.bodyMap = bodyMap;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
