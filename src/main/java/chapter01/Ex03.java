package chapter01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex03 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		Greeter g1 = ctx.getBean("greeter",Greeter.class);
		Greeter g2 = ctx.getBean("greeter",Greeter.class);
		
		System.out.println("두 겍체가 같은 객체인가요 "+ (g1 == g2));
		
		ctx.close();
	}
}
