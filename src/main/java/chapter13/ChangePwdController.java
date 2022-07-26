package chapter13;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import exception.WrongIdPasswordException;

@Controller
@RequestMapping("/edit/changePassword")
public class ChangePwdController {
	private ChangePasswordService changePasswordService;
	
	public void setChangePasswordService(ChangePasswordService changePasswordService) {
		this.changePasswordService = changePasswordService;
	}
	
	@GetMapping
	public String showChangePwdForm() {
		return "edit/form";
	}
	
	@PostMapping
	public String changePassword(ChangePasswordCommand changePasswordCommand,Errors errors,HttpSession session ) {
		new ChangePasswordCommandValidator().validate(changePasswordCommand, errors);
		
		if(errors.hasErrors()) {
			return "edit/form";
		}
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		String email = authInfo.getEmail();
		
		try {
			changePasswordService.changePassword(email, changePasswordCommand.getCurrentPassword(), changePasswordCommand.getNewPassword());

			session.setAttribute("authInfo", authInfo);
			
			return "edit/success";
		}catch(WrongIdPasswordException e) {
			errors.rejectValue("currentPassword", "notMatching");
		
			return "edit/form";
		}
	}
}
