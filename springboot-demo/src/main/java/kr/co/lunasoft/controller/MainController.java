package kr.co.lunasoft.controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.co.lunasoft.model.ResponseInfo;
import lombok.extern.slf4j.Slf4j;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/")
@Slf4j
@ApiIgnore
public class MainController {

	@GetMapping("favicon.ico")
	@ResponseBody
	void returnNoFavicon() {
	}

	@GetMapping(value = "/health-check")
	public JSONObject healthCheck() {
		JSONObject data = new JSONObject();
		data.put("code", "100200");
		data.put("msg", "Success");
		data.put("data", null);
		return data;
	}

}
