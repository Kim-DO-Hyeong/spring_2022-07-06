package chapter06;

public class ImplCalculator2 implements Calculator{

	@Override
	public long factorial(int num) {
		if (num ==1) {
			return 1;
		}else {
			return num*factorial(num-1);
		}
	}	
}
