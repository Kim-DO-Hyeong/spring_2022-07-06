package chapter05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppCtx {
	
	@Bean
	public Client client1() {
		Client client1 =  new Client();
		client1.setHost("192.168.10.15");
	
		return client1;
	}
	
	@Bean 
	public Client2 client2() {
		Client2 client2 =  new Client2();
		
//		client2.setHost("127.0.0.1");
	
		return client2;
	}
	
	@Bean(initMethod = "connect", destroyMethod = "close")
	@Scope("prototype") // 원래는 싱글톤이지만 프로토타입으로 바꿀수 있는 애노테이션 -> 꺼낼때마다 새로운 객체를 생성 
	public Client3 client3() {
		Client3 client3 = new Client3();
		
		client3.setHost("localHost");
		
		return client3;
	}
	
}
