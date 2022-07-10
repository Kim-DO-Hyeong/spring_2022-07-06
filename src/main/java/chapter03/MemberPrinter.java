package chapter03;

import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

public class MemberPrinter {
	
	@Autowired(required = false) // 자동주입사항이 선택사항으로 만들 수 있음 
	//	@Nullable // required = false  속성 대신 이 애노테이션을 사용 할 수 있음
	private DateTimeFormatter dtf;

	public void print(Member member) {
		
		String text1  = "아이디 : " + member.getId();
		String text2  = "이메일 : " + member.getEmail();
		String text3  = "이름 : " + member.getName();
		String text4  = "등록일 : " + member.getRegisterDateTime();
		
		if(dtf !=null) {
			text4 = "등록일 : " + dtf.format(member.getRegisterDateTime());
		}
		
		String text = "회원정보 : "+ text1+","+ text2+"," +text3+"," +text4;
		
		System.out.println(text);
		
		
	}
}
