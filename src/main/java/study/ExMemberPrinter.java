package study;

import org.springframework.stereotype.Component;

@Component
public class ExMemberPrinter extends MemberPrinter {

	@Override
	public void printer(Member member) {

			String id = "아이디 = "+member.getId();
			String name ="이름 = "+member.getName();
			String pw = "비번 = "+ member.getPw();
			System.out.println("회원정보 : "+id+", "+name+", "+pw);
		}
	}
	
	
