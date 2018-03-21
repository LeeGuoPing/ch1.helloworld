package ch1.helloworld.intercepters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * 自定义拦截器,从入口类扫描包及其子包,会扫描到这个类
 * @author liguoping
 *
 * 2018年3月22日-上午12:30:11
 */
@Configuration
public class MySpringMVCConfig extends WebMvcConfigurerAdapter{
	
	public void addInterceptors(InterceptorRegistry registry) {
		HandlerInterceptor handlerInterceptor = new HandlerInterceptor() {
			
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
				System.out.println("自定义拦截器执行... ...");
				return true;
			}
			
			@Override
			public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
					ModelAndView modelAndView) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
					throws Exception {
				// TODO Auto-generated method stub
				
			}
			
		};
		registry.addInterceptor(handlerInterceptor);
	}
}
