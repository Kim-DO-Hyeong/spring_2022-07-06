package chapter03;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberListPrinter {
	// 생성자 방식으로 의존 주입을 하는 빈 객체는 
	// 자동 의존 주입(@Autowired)  애너테이션이 적용할 숭 없음
	// 왜지라 생각들면 생성자 복습
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	@Qualifier("printer2")
	private MemberPrinter memberPrinter;
	
	public void setMemberPrinter(MemberPrinter memberPrinter) {
		this.memberPrinter = memberPrinter;
	}
	
	public void printAll() {
		Collection<Member> memberList = memberDao.selectAll();
		
		for(Member member : memberList) {
			memberPrinter.print(member);
		}
	
		System.out.println();
	}
	
}
