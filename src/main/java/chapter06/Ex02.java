package chapter06;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chapter06.config.AppCtx;

public class Ex02 {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		Calculator cal = ctx.getBean("calculator",Calculator.class);
		
		long result = cal.factorial(5);
		result = cal.factorial(5);
		result = cal.factorial(5);
		result = cal.factorial(5);
		
		System.out.println("5! = "+ result);
		
		ctx.close(); 
	}
}
