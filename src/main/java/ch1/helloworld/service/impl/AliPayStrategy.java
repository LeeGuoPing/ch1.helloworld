package ch1.helloworld.service.impl;

import ch1.helloworld.enums.PayEnum;
import ch1.helloworld.service.PayStrategy;
import org.springframework.stereotype.Component;

/**
 * 支付宝
 *
 * @author liguoping
 * @since 2020/11/13 11:50
 */
@Component("aliPayStrategy")
public class AliPayStrategy implements PayStrategy {

    @Override
    public String pay(String amount) {
        return String.format(MSG, PayEnum.ALI_PAY.getDescription(), amount);
    }
}
