package kr.co.lunasoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/view")
@Slf4j
@Api(tags = { "8. View" })
public class ViewController {
	
	@ApiOperation("index page")
	@GetMapping(value="index")
	public String index() {
		return "index";
	}
	
	@ApiOperation("vue.js sample page")
	@GetMapping(value="vue1")
	public String vue1() {
		return "vue1";
	}

	@ApiOperation("vue.js sample page")
	@GetMapping(value="vue2")
	public String vue2() {
		return "vue2";
	}
	
}
