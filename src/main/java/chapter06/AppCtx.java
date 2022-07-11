package chapter06;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {
	
	@Bean
	public ImplCalculator1 implCalculator1() {
		return new ImplCalculator1();
	}
	
	@Bean
	public ImplCalculator2 implCalculator2() {
		return new ImplCalculator2();
	}
	
	@Bean
	public ExecTimeCalculator etc1() {
		ExecTimeCalculator etc = new ExecTimeCalculator(implCalculator1());
		return etc;
	}
	
	@Bean
	public ExecTimeCalculator etc2() {
		ExecTimeCalculator etc = new ExecTimeCalculator(implCalculator2());
		return etc;
	}
	
}
