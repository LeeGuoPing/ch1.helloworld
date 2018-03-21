package ch1.helloworld;



import java.nio.charset.Charset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;

@SpringBootApplication
public class Ch1Application{
	
	public static void main(String[] args) {
		SpringApplication.run(Ch1Application.class, args);
		System.out.println();
		System.out.println("start succes!!!!!!!!!!!!!!!!!");
		System.out.println();
	}
	
	/**
	 * 自定义消息转换器
	 * 在spring boot中默认是utf-8不需要设置
	 */
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter(){
		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("utf-8"));
		return stringHttpMessageConverter;
	}

}
