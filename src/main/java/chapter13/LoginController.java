package chapter13;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
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
	public String form(LoginCommand loginCommand, @CookieValue(value = "remember", required = false) Cookie cookie) {
//		model.addAttribute("loginCommnad",new LoginCommand());

		// 이매일 기억하기 쿠키가 있다면 클라이언트에게 쿠키에 저장된 이메일을 보내도록 하세요
		// 서블릿에서 쿠키 꺼내서 전달
//		Cookie[] cookies = request.getCookies();
//		for(Cookie cookie : cookies) {
//			if(cookie.getName().equals("remember")) {
//				model.addAttribute("email",cookie.getValue());
//			}
//		}
		
		if(cookie != null) {
			loginCommand.setEmail(cookie.getValue());
			loginCommand.setRememberEmail(true);
		}

		return "login/form";
	}

	// 로그인 화면에서 로그인 버튼을 눌렸을 때
	// AuthService 를 사용해서 로그인에 성공한 사용자의 정보를 가져오는 컨트롤러를 추가하세요
	// 로그인 화면에서 이메일, 비밀번호를 올바르게 입력해 로그인에 성공한 사용자의 정보를 가져온 후에느느
	// login 폴더에서 success.jsp 페이지를 보여줘야 합니다
	// 로그인 화면에서 이메일 또는 비밀번호를 잚 못 입력해 로그인을 하지 못했다면
	// 다시 로그인 화면을 보여줘야 합니다

	@PostMapping("/login")
	public String login(LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response) {
		new LoginCommandValidator().validate(loginCommand, errors);

		if (errors.hasErrors()) {
			return "login/form";
		}

		try {
			String email = loginCommand.getEmail();
			String password = loginCommand.getPassword();

			AuthInfo authInfo = service.authenticate(email, password);

			session.setAttribute("authInfo", authInfo);

			if (loginCommand.isRememberEmail()) {
				Cookie remeberCookie = new Cookie("remember", loginCommand.getEmail());

				response.addCookie(remeberCookie);
			}

			return "login/success";

		} catch (WrongIdPasswordException e) {
			errors.reject("idOrPasswordNotMatching"); // reject 커맨드 객체 자체에 에러 코드를 설정
			return "login/form";
		}
	}

}
