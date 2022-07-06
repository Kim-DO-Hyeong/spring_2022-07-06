package chapter01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex02 {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		// ctx가 가지고 있는 greeter객체를 꺼내라 ( 타입은 Greeter ) 
		Greeter greeter = ctx.getBean("greeter",Greeter.class);

		String msg = greeter.greet("스프링");
		
		System.out.println(msg);
		
		ctx.close();
		
	}

}
