package chapter07;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex03 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		MemberDao memberDao = ctx.getBean("memberDao",MemberDao.class);
		
		List<Member> list = (List<Member>)memberDao.selectAll();
		
		if(list == null) {
			System.out.println("가입된 회원이 없습니다");
		}else {
			for(Member m : list) {
				System.out.println(m.getId() + ", "+m.getEmail() + ", "+m.getName());
			} 
		}
		
//		Member newMember = new Member("b@gmail.com", "2134", "고영희", LocalDateTime.now());
//		
//		memberDao.insert(newMember);
		
		ctx.close();
		
	}
}
