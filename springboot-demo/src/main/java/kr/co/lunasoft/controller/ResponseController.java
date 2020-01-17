package kr.co.lunasoft.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import kr.co.lunasoft.model.ResponseInfo;

@RestController
@RequestMapping("/response")
@Api(tags = { "response" })
public class ResponseController {
	
	@GetMapping(value = "/list")
	public ResponseEntity<Object> list(){
		ResponseInfo response = new ResponseInfo("100200", "test data", "test message");
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}

}
