package ch1.helloworld.factory;

import ch1.helloworld.enums.PayEnum;
import ch1.helloworld.service.PayStrategy;
import ch1.helloworld.utils.SpringContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 支付工厂类
 *
 * @author liguoping
 * @since 2020/11/13 11:39
 */
@Component
public class PayServiceFactory {

    @Autowired
    private SpringContextUtils springContextUtils;

    public PayStrategy getPayService(String channel) {
        String service = PayEnum.getServiceByChannel(channel);
        if(service == null){
           return null;
        }
        return springContextUtils.getBean(service, PayStrategy.class);
    }
}
