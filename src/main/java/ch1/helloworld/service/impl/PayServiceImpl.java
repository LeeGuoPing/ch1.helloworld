package ch1.helloworld.service.impl;

import ch1.helloworld.enums.PayEnum;
import ch1.helloworld.service.PayService;
import org.springframework.stereotype.Service;

/**
 * 支付接口
 *
 * @author liguoping
 * @since 2020/11/13 11:11
 */
@Service("payService")
public class PayServiceImpl implements PayService {

    private static final String MSG = "使用 %s ,消费了 %s 元";

    @Override
    public String pay(String channel, String amount) throws Exception {
        if (PayEnum.ALI_PAY.getChannel().equals(channel)) {
            //支付宝
            //业务代码...
            return String.format(MSG, PayEnum.ALI_PAY.getDescription(), amount);
        } else if (PayEnum.WECHAT_PAY.getChannel().equals(channel)) {
            //微信支付
            //业务代码...
            return String.format(MSG, PayEnum.WECHAT_PAY.getDescription(), amount);
        } else if (PayEnum.UNION_PAY.getChannel().equals(channel)) {
            //银联支付
            //业务代码...
            return String.format(MSG, PayEnum.UNION_PAY.getDescription(), amount);
        } else if (PayEnum.XIAO_MI_PAY.getChannel().equals(channel)) {
            //小米支付
            //业务代码...
            return String.format(MSG, PayEnum.XIAO_MI_PAY.getDescription(), amount);
        } else {
            return "输入渠道码有误";
        }
    }
}
