package study;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberPrinter {
	
	public DateTimeFormatter dtf;
	
	public void printer(Member member) {

		String id = "아이디 = "+member.getId();
		String name ="이름 = "+member.getName();
		String registDate ="등록 날짜 = "+member.getRegistDateTime();
		
		if( dtf != null) {
			registDate = "등록 날짜 = "+dtf.format(member.getRegistDateTime());
		}
		
		System.out.println("회원정보 : "+id+","+name+", "+registDate);
	}
	
	@Autowired
	public void setDateTimeFormatter(DateTimeFormatter dtf) {
		this.dtf = dtf;
	}
}
