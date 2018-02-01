package ch1.helloworld;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;

@SpringBootApplication
public class Ch1Application implements EmbeddedServletContainerCustomizer{
	
	public static void main(String[] args) {
		SpringApplication.run(Ch1Application.class, args);
		System.out.println("start success      _     ");
		System.out.println("start success     | |    ");
		System.out.println("start success    _| |_    ");
		System.out.println("start success  _|_| |_|_ ");
		System.out.println("start success | | | | | |");
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer container) {
		container.setPort(80);
		
	}
}
