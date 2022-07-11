package chapter06;

public class ExecTimeCalculator implements Calculator {
	
	private Calculator delegate;
	
	public ExecTimeCalculator(Calculator delegate) {
		this.delegate = delegate;
	}
	
	@Override
	public long factorial(int num) {
		long start = System.nanoTime();
		
		long result = delegate.factorial(num);
		
		long end = System.nanoTime();

		System.out.println("factorial 소요 시간=> "+(end-start));
		
		return result;
	
		
	}

}
