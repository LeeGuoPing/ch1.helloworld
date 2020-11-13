package ch1.helloworld.controller;

import ch1.helloworld.service.PayService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 支付控制器，策略模式试玩
 *
 * @author liguoping
 * @since 2020/11/13 11:08
 */

@RestController
@RequestMapping("/payController")
public class PayController {

    @Resource(name = "payService")
    private PayService payService;

    /**
     * 支付接口
     *
     * @param channel 渠道
     * @param amount  消费金额
     * @return String 返回消费结果
     */
    @RequestMapping("/pay")
    public String pay(@RequestParam(name = "channel") String channel,
                      @RequestParam(name = "amount") String amount) throws Exception {
        return payService.pay(channel, amount);
    }
}
