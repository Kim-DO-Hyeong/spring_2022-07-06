package chapter13;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginCommandValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return LoginCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required");
		// errors 안에 target 복사가 되어있어서 target 을 검증 할 수 있음 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		
	}

}
