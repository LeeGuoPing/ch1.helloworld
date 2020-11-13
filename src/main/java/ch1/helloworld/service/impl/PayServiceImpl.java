package ch1.helloworld.service.impl;

import ch1.helloworld.enums.PayEnum;
import ch1.helloworld.event.PayEvent;
import ch1.helloworld.factory.PayServiceFactory;
import ch1.helloworld.service.PayService;
import ch1.helloworld.service.PayStrategy;
import ch1.helloworld.utils.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

/**
 * 支付接口
 *
 * @author liguoping
 * @since 2020/11/13 11:11
 */
@Service("payService")
public class PayServiceImpl implements PayService {

    @Autowired
    private SpringContextUtils springContextUtils;

    @Autowired
    private PayServiceFactory payServiceFactory;

    @Override
    public String pay(String channel, String amount) {
        PayStrategy payStrategy = payServiceFactory.getPayService(channel);
        if(payStrategy == null){
            return "输入渠道码有误";
        }
        String msg = payStrategy.pay(amount);
        Map<String, String> bodyMap = Collections.singletonMap("msg", msg);

        // 发布事件
        PayEvent payEvent = new PayEvent(this,bodyMap,"支付");
        springContextUtils.getContext().publishEvent(payEvent);
        return msg;
    }
}
