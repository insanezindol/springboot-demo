package kr.co.lunasoft.controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@Slf4j
public class MainController {
	
	@GetMapping("favicon.ico")
    @ResponseBody
    void returnNoFavicon() {
    }

	@GetMapping(value = "/test")
	public JSONObject logic() {
		JSONObject data = new JSONObject();
		data.put("code", "100200");
		data.put("msg", "Success");
		data.put("data", null);
		return data;
	}

}
