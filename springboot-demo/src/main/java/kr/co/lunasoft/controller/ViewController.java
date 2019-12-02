package kr.co.lunasoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/view")
@Slf4j
public class ViewController {
	
	@RequestMapping(value="test1")
	public String test1() {
		log.info("test1");
		return "test1";
	}

	@RequestMapping(value="test2")
	public String test2() {
		log.info("test2");
		return "test2";
	}
	
}
