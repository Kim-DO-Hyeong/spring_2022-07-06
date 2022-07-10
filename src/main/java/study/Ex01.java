package study;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
	
	public static void main(String[] args) {
		ApplicationContext	ctx = new AnnotationConfigApplicationContext(AppCtx2.class);
		
		StudyDao studyDao = ctx.getBean("study",StudyDao.class);
		
		Member member = new Member();
		String id = "id1";
		String pw = "pw1";
		String name  = "홍길동";
		
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		member.setRegistDateTime(LocalDateTime.now());
		
		studyDao.insert(member);
		
		Member member2 = new Member();

		member2.setId("id2");
		member2.setPw("pw2");
		member2.setName("고영희");
		member2.setRegistDateTime(LocalDateTime.of(2022, 4, 4, 12, 0));
		
		studyDao.insert(member2);
		
		Scanner scanf = new Scanner(System.in);
		System.out.println("검색할 회원의 이름을 입력하세요");
		String findName = scanf.next();
		
		MemberInfoPrinter memberInfoPrinter = ctx.getBean("memberInfoPrinter",MemberInfoPrinter.class);
		
		memberInfoPrinter.memberInfoPrinter(findName);
		
	}

}
