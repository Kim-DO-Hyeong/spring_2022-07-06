package chapter06;


public class Ex01 {

	public static void main(String[] args) {

		ImplCalculator1 cal1 = new ImplCalculator1();

		ImplCalculator2 cal2 = new ImplCalculator2();

		// ExecTimeCalculator 를 사용해서 
		// 반복문으로 factorial 계산 시 소요시간을 출력
		// 재귀함수로 factorial 계산 시 소요시간을 출력

		Calculator cal = new ImplCalculator1();
		System.out.println(cal);
		
		cal = new ImplCalculator2();
		System.out.println(cal);
		
		
		ExecTimeCalculator etc1 = new ExecTimeCalculator(cal1);
		etc1.factorial(1000);
		ExecTimeCalculator etc2 = new ExecTimeCalculator(cal2);
		etc2.factorial(1000);
		
		
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
//		
//		ExecTimeCalculator etc1 = ctx.getBean("etc1",ExecTimeCalculator.class);
//		etc1.factorial(1000);
//		
//		ExecTimeCalculator etc2 = ctx.getBean("etc2",ExecTimeCalculator.class);
//		etc2.factorial(1000);
//		
//		ctx.close();
	}

}
