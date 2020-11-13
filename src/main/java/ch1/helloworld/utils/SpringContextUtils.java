package ch1.helloworld.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring 上下文工具类，获取 Bean
 *
 * @author liguoping
 * @since 2020/11/13 11:44
 */
@Component
public class SpringContextUtils implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public <T> T getBean(String bean, Class<T> t){
        return context.getBean(bean,t);
    }
}
