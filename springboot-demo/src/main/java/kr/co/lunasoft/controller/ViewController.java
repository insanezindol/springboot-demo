package kr.co.lunasoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/view")
@Slf4j
public class ViewController {
	
	@RequestMapping(value="vue1")
	public String vue1() {
		return "vue1";
	}

	@RequestMapping(value="vue2")
	public String vue2() {
		return "vue2";
	}
	
}
