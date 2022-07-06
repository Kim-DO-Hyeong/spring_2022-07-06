package chapter01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
	
//	@Bean
//	public Greeter greeter() {
//		
//		Greeter greeter = new Greeter();
//		
//		greeter.setFormat("%s, 드디어 시작");
//		
//		return greeter;
//	}
	
	@Bean
	public Greeter greeter1() {
		
		Greeter greeter = new Greeter();
		
		greeter.setFormat("%s, 드디어 시작");
		
		return greeter;
	}
	@Bean
	public Greeter greeter2() {
		
		Greeter greeter = new Greeter();
		
		greeter.setFormat("%s, 드디어 시작");
		return greeter;
	}
}
