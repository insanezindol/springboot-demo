package kr.co.lunasoft.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kr.co.lunasoft.model.ErrorInfo;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class DefaultExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ErrorInfo defaultExceptionMethod(Exception e) {
		log.error("[ERROR] - " + e.getMessage());
		ErrorInfo errorInfo = new ErrorInfo("100104", null, "Invalid Api");
		return errorInfo;
	}

}
