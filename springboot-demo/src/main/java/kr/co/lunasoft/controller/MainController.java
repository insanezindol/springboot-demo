package kr.co.lunasoft.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.lunasoft.util.HttpConnectionUtil;
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
	public Map<String, Object> healthCheck() {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("code", "100200");
		data.put("msg", "Success");
		data.put("data", null);
		return data;
	}
	
	@GetMapping(value = "/call-check")
	public Map<String, Object> callCheck() {
		String serverUrl = "https://api.upbit.com/v1/orderbook";
		
		List<NameValuePair> parameters = new ArrayList<>();
		parameters.add(new BasicNameValuePair("markets", "KRW-BTC"));
		
		String result1 = HttpConnectionUtil.sendGet(serverUrl, parameters);
		String result2 = HttpConnectionUtil.sendPost(serverUrl, parameters);
		
		log.info(result1);
		log.info(result2);
		
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("code", "100200");
		data.put("msg", "Success");
		data.put("data", null);
		return data;
	}

}
