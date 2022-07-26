package chapter13;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ChangePasswordCommandValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ChangePasswordCommand.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentPassword", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword", "required");
		
		ChangePasswordCommand changePasswordCommand = (ChangePasswordCommand) target;
		
		String newPassword = changePasswordCommand.getNewPassword();
		String confirmNewPassword = changePasswordCommand.getConfirmNewPassword();
		
		if(!newPassword.equals(confirmNewPassword)) {
			errors.rejectValue("confirmNewPassword", "NotMatching");
		}
		
	}
	
}
