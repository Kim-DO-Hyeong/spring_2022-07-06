package chapter05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Client client1 = ctx.getBean("client1",Client.class);
		client1.send();
		
		Client2 client2 = ctx.getBean("client2",Client2.class);
		client2.send();
		
		ctx.close();
	}

}
