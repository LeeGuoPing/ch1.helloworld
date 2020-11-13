package ch1.helloworld.service;

/**
 * 支付策略接口
 *
 * @author liguoping
 * @since 2020/11/13 11:53
 */
public interface PayStrategy {

    String MSG = "使用 %s ,消费了 %s 元";

    String pay(String amount);
}
