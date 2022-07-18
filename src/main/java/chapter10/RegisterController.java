package chapter10;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import exception.DuplicateMemberException;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	private MemberRegisterService memberRegisterService;
	
	public void setMemberRegisterService(MemberRegisterService memberRegisterService) {
		this.memberRegisterService = memberRegisterService;
		
	}

	@GetMapping("/step1")
	public String handleStep1() {
		
		return "register/step1";
		
		// 약관 동의 화면 JSP : /WEB-INF/view//register/step1.jsp 가 되서 / 하나 빼줌
	}

	@PostMapping("/step2")
	public String handleStep2(Model model, @RequestParam(value = "agree",required=false) boolean agree) {
		
		if(!agree) {
			return "redirect:/register/step1";
		}
		return "register/step2";
	}	
	
//	@GetMapping("/step2")
//	public String dneyAccess() {
//		System.out.println("잘못된 접근입니다");
//		return "register/step2";
//	}

	@RequestMapping(value="/step3",method=RequestMethod.POST) // get , post 둘 다 지원 가능
	public String handleStep3(RegisterRequest registerRequest) {
		// 스프링이 클래스를 보고 멤버 변수 확인 하고 
		// 이름에 맞춰서 각각 똑같은 이름의 멤버변수로 만들어줌 
		// 스프링이 RegisterRequest 를 커멘드 객체라고 부름 
		
		try{
			memberRegisterService.regist(registerRequest);
			//..
			
			return "redirect:/register/step3";
		}catch(DuplicateMemberException e) {
			return "register/step2";
		}
		
		
	}

	
}
