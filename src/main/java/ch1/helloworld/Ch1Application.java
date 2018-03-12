package ch1.helloworld;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

@SpringBootApplication
public class Ch1Application{
	
	public static void main(String[] args) {
		SpringApplication.run(Ch1Application.class, args);
		System.out.println();
		System.out.println("start succes!!!!!!!!!!!!!!!!!");
		System.out.println();
	}

}
