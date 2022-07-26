package chapter13;


import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MemberListController {
	private MemberDao memberDao;
	
	public void setMemberDao (MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	@GetMapping("/members")
	public String list(@ModelAttribute("cmd") MemberListCommand memberListCommand, Model model) {
		
		if(memberListCommand.getFrom() != null && memberListCommand.getTo() != null) {
			List<Member> members  = memberDao.selectByRegDate(memberListCommand.getFrom(), memberListCommand.getTo());
		
			model.addAttribute("members",members);
		}
		
		return "members/list";
	}
	
	// 서버가 받아들일 수 있는 형식의 데이터가 아니라
	// 받아들일 수 없는 형식의 데이터를 보내면
	// 서버는 TypeMismatchException을 발생시키면서
	// 클라이언트에게는 400 에러 페이지를 보내줌
	@GetMapping("/member/detail/{memberNumber}")
	public String detail(@PathVariable("memberNumber") long memberNumber, Model model) {
		
		Member member = memberDao.selectByMemberNumber(memberNumber);
		if(member != null) {
			// 요청 정보 영역에 조회한 회원 정보 저장
			model.addAttribute("member",member);
		}
		
		return "members/detail";
	}
	
	// 컨트롤러 안에서 TypeMismatchException 예외가 발생했을 때 
	// 메서드 안에 코드가 동작
	@ExceptionHandler(TypeMismatchException.class)
	public String handleTypeMismatchException() {
		return "members/invalidMemberNumber";
	}
}
