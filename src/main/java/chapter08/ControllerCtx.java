package chapter08;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerCtx {
	
	@Bean 
	// 실제 이 코드를 실행하기 위해서는 DispatcherServlet 안에는 HandlerMapping / HandlerAdaptor / ViewResolver / HelloController 가 들어있는 것
	// HelloController 와 Dispatcher 직접적으로 연결되지 않고 HandlerAdaptor를 통해서 연결 
	public HelloController helloController() {
		return new HelloController();
	}
	
}
