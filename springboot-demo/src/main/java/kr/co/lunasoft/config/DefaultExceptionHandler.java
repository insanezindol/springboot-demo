package kr.co.lunasoft.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kr.co.lunasoft.model.ResponseInfo;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class DefaultExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseInfo defaultExceptionMethod(Exception e) {
		// log.error("[ERROR] - " + e.getMessage());
		ResponseInfo responseInfo = new ResponseInfo("100104", null, "Invalid Api");
		return responseInfo;
	}

}
