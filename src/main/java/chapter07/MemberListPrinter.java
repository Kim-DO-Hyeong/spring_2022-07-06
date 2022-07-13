package chapter07;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class MemberListPrinter {
	
	private MemberDao memberDao;
	
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
