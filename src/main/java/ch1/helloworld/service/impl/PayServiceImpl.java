package ch1.helloworld.service.impl;

import ch1.helloworld.factory.PayServiceFactory;
import ch1.helloworld.service.PayService;
import ch1.helloworld.service.PayStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 支付接口
 *
 * @author liguoping
 * @since 2020/11/13 11:11
 */
@Service("payService")
public class PayServiceImpl implements PayService {

    @Autowired
    private PayServiceFactory payServiceFactory;

    @Override
    public String pay(String channel, String amount) {
        PayStrategy payStrategy = payServiceFactory.getPayService(channel);
        if(payStrategy == null){
            return "输入渠道码有误";
        }
        return payStrategy.pay(amount);
    }
}
