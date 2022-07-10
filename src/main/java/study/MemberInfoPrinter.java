package study;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class MemberInfoPrinter {
	@Autowired
	@Qualifier("study")
	public StudyDao studyDao;
	
	@Autowired
	@Qualifier("p")
	public MemberPrinter memberPrinter;
	
	public MemberInfoPrinter() {
	
	}
	public void memberInfoPrinter(String name) {
		Member member = studyDao.selectByName(name);
		memberPrinter.printer(member);
	}
	
}
