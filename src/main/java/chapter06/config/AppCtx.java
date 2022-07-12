package chapter06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import chapter06.Calculator;
import chapter06.ImplCalculator1;
import chapter06.aspect.CacheAspect;
import chapter06.aspect.ExecTimeAspect;

@Configuration
@EnableAspectJAutoProxy
public class AppCtx {
	
	@Bean
	public ExecTimeAspect execTimeAspect() {
		return new ExecTimeAspect();
	}
	
	@Bean // getBean("calculator",Calculator.class)
	public Calculator calculator() {
		return new ImplCalculator1();
	}
	
	@Bean
	public CacheAspect cacheAspect() {
		return new CacheAspect();
	}
	
	
//	@Bean
//	public ImplCalculator1 implCalculator1() {
//		return new ImplCalculator1();
//	}
//	
//	@Bean
//	public ImplCalculator2 implCalculator2() {
//		return new ImplCalculator2();
//	}
//	
//	@Bean
//	public ExecTimeCalculator etc1() {
//		ExecTimeCalculator etc = new ExecTimeCalculator(implCalculator1());
//		return etc;
//	}
//	
//	@Bean
//	public ExecTimeCalculator etc2() {
//		ExecTimeCalculator etc = new ExecTimeCalculator(implCalculator2());
//		return etc;
//	}

	
}
