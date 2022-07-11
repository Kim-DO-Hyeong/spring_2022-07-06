package chapter05;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Client2 implements InitializingBean,DisposableBean{
	private String host;
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public void send() {
		System.out.println("send to "+host);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("빈 객체가 초기화 되는 중");
		
		setHost("127.0.0.1");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("빈객체가 사라지는 중");
		setHost(null);
	}
	
	
	
}	
