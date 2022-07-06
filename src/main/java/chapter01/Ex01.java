package chapter01;

public class Ex01 {

	public static void main(String[] args) {
		Greeter greeter = new Greeter();
		
		greeter.setFormat("%s, 드디어 시작 !");
		String msg = greeter.greet("스프링");
		
		System.out.println(msg);
		
	}

}
