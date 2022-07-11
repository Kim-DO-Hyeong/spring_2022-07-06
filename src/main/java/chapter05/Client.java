package chapter05;

public class Client {
	private String host;
	
	public void setHost(String host) {
		this.host = host;
	}
	
	public void send() {
		System.out.println("send to "+host);
	}
}
