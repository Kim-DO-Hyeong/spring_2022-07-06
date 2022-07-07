package chapter02;

import java.util.Collection;

public class MemberListPrinter {
	
	private MemberDao memberDao;
	private MemberPrinter memberPrinter;

	// printAll 메서드를 보고 생성자 방식으로 DI  	
	public MemberListPrinter(MemberDao memberDao, MemberPrinter memberPrinter) {
		this.memberDao = memberDao;
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
