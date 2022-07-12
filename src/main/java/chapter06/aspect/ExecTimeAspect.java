package chapter06.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class ExecTimeAspect {
	
	@Pointcut("execution(public * chapter06.*.*(..))")
	private void publicTarget() {
		
	}
	
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) {
		try {
			long start = System.currentTimeMillis();
			
			Object result = joinPoint.proceed(); // 핵심기능이 동작학 Object로 리턴해줌 
			
			long end = System.currentTimeMillis();
			
			long duration = end - start;
			System.out.println("핵심 기능이 동작하는데 "+duration+ "밀리초가 소요되었습니다");
			
			return result;
		}catch(Throwable e) {
			System.out.println("AOP 동작 중 알 수 없는 예외가 발생하였습니다");
			
			e.printStackTrace();
			
			return null;
		}
	}
}
