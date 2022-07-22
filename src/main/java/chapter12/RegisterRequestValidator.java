package chapter12;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class RegisterRequestValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// Validator 의 용도를 결정하는 메서드
		
		return RegisterRequest.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// 커멘드 객체가 가지고 있는 값을 검증하는 메서드
		
		// target -> 커맨드 객체를 받는 매개변수 -> command 객체를 받을 때 변환 필요 
		RegisterRequest regReq = (RegisterRequest)target;
		
		String email = regReq.getEmail();
		if(email == null ||email.trim().isEmpty()) {
			errors.rejectValue("email", "requried");
		}else {
			String emailRegExp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
			Pattern pattern = Pattern.compile(emailRegExp);
			Matcher matcher = pattern.matcher(email);
			
			if(!matcher.matches()) {
				errors.rejectValue("email", "bad");
				// 상태 코드 대신 에러코드를 전송 
			}
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
		// name null 이거나 공백문자이면 에러코드를 저장 
		
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
		ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
		
		if(!regReq.isPasswordEqualToConfirmPassword()) {
			errors.rejectValue("confirmPassword", "notMatch");
		}
		
	}

}
