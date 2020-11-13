package ch1.helloworld.service;

/**
 * 支付接口
 *
 * @author liguoping
 * @since 2020/11/13 11:10
 */
public interface PayService {

    /**
     * 支付接口
     * @param channel 渠道
     * @param amount 金额
     * @return 支付结果
     * @throws Exception 异常
     */
    String pay(String channel, String amount) throws Exception;
}
