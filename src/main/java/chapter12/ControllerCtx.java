package chapter12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ServiceCtx.class})
public class ControllerCtx {
	
	@Autowired
	private MemberRegisterService memberRegisterService;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@Bean
	public RegisterController registerController() {
		RegisterController registerController = new RegisterController();
		registerController.setMemberRegisterService(memberRegisterService);
		
		return registerController;
	}
	
	@Bean
	public SurveyController surveyController() {
		return new SurveyController();
	}
	
	public AuthService authSvc() {
		AuthService svc = new AuthService();
		svc.setMemberDao(memberDao);
		return svc;
	}
	
	@Bean
	public LoginController loginController() {
		LoginController loginController = new LoginController();
		loginController.setService(authSvc());
		return loginController;
	}
	
	@Bean
	public ChangePwdController changePwdController() {
		ChangePwdController changePwdController = new ChangePwdController();
		changePwdController.setChangePasswordService(changePasswordService);
		return changePwdController;
	}
	
	
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	
	
	
}
