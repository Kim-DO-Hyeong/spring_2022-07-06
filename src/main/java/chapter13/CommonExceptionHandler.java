package chapter13;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("chapter13")
public class CommonExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public String handlerRuntimeExcetion() {
		return "error/commonRuntime";
	}
}
