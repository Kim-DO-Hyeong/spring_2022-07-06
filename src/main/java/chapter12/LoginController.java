package chapter12;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import exception.WrongIdPasswordException;

@Controller
public class LoginController {

	public AuthService service;

	public void setService(AuthService service) {
		this.service = service;
	}

	@GetMapping("/login")
	public String form(LoginCommand loginCommand) {
//		model.addAttribute("loginCommnad",new LoginCommand());

		return "login/form";
	}

	// 로그인 화면에서 로그인 버튼을 눌렸을 때
	// AuthService 를 사용해서 로그인에 성공한 사용자의 정보를 가져오는 컨트롤러를 추가하세요
	// 로그인 화면에서 이메일, 비밀번호를 올바르게 입력해 로그인에 성공한 사용자의 정보를 가져온 후에느느
	// login 폴더에서 success.jsp 페이지를 보여줘야 합니다
	// 로그인 화면에서 이메일 또는 비밀번호를 잚 못 입력해 로그인을 하지 못했다면
	// 다시 로그인 화면을 보여줘야 합니다

	@PostMapping("/login")
	public String login(LoginCommand loginCommand, Errors errors, HttpSession session) {
		new LoginCommandValidator().validate(loginCommand, errors);

		if (errors.hasErrors()) {
			return "login/form";
		}

		try {
			String email = loginCommand.getEmail();
			String password = loginCommand.getPassword();

			AuthInfo authInfo = service.authenticate(email, password);
			
			session.setAttribute("authInfo", authInfo);

			return "login/success";

		} catch (WrongIdPasswordException e) {
			errors.reject("idOrPasswordNotMatching"); // reject 커맨드 객체 자체에 에러 코드를 설정
			return "login/form";
		}
	}

}
