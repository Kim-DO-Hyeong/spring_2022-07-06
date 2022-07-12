package chapter06.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class CacheAspect {
	private Map<Long,Object> cache = new HashMap<>();
	
	@Pointcut("execution(public * chapter06.*.*(..))")
	public void cacheTarget() {
		
	}
	
	@Around("cacheTarget()")
	public Object execute(ProceedingJoinPoint joinPoint) {
		try {
			int temp =(int)joinPoint.getArgs()[0];
			long num = (long) temp;
			// getArgs() 메서드는 factorial 안의 인자를 배열로 리턴 
			
			if(cache.containsKey(num)) {
				long result = (long) cache.get(num);
			
				System.out.println("CacheAspect : cache 에서 "+num+" key의 값 "+result + " 찾음");
				return result;
			}
			
			Object result = joinPoint.proceed();
			
			cache.put(num, result);
			
			System.out.println("CacheAspect : cache 에서 "+num+" key의 값 "+result + " 추가");
			return result;
		}catch(Throwable e) {
			System.out.println("Aspect가 동작 중 알 수 없는 예외가 발생했습니다");
			e.printStackTrace();
			return null;
		}
		
		
	}
}
