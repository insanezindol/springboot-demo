package kr.co.lunasoft.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.co.lunasoft.model.HumanInfo;
import kr.co.lunasoft.model.ResponseInfo;
import kr.co.lunasoft.service.RedisService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/redis")
@Slf4j
@Api(tags = { "4. Redis" })
public class RedisController {

	@Autowired
	private RedisService redisService;

	@ApiOperation("redis에서 해당key의 value를 리턴한다.")
	@ApiImplicitParams({ @ApiImplicitParam(name = "key", value = "조회할 key 값", required = true, dataType = "string", paramType = "path", defaultValue = "test_key"), })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@GetMapping(value = "/get/str/{key}")
	public Map<String, Object> getStr(@PathVariable String key) {
		Map<String, Object> obj = new HashMap<String, Object>();

		obj.put("code", "100200");
		obj.put("msg", "success");
		obj.put("data", redisService.get(key));
		return obj;
	}

	@ApiOperation("redis에 key의 value를 저장한다.")
	@ApiImplicitParams({ @ApiImplicitParam(name = "key", value = "저장할 key 값", required = true, dataType = "string", paramType = "path", defaultValue = "test_key"), @ApiImplicitParam(name = "value", value = "저장할 value 값", required = true, dataType = "string", paramType = "path", defaultValue = "test_value"), })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@PostMapping(value = "/set/str/{key}/{value}")
	public Map<String, Object> setStr(@PathVariable String key, @PathVariable String value) {
		Map<String, Object> obj = new HashMap<String, Object>();

		try {
			redisService.set(key, value);
			obj.put("code", "100200");
			obj.put("msg", "success");
			obj.put("data", "");
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			obj.put("code", "100104");
			obj.put("msg", "fail set redis key");
			obj.put("data", "");
		}
		return obj;
	}

	@ApiOperation("redis에서 해당key의 value를 삭제한다.")
	@ApiImplicitParams({ @ApiImplicitParam(name = "key", value = "삭제할 key 값", required = true, dataType = "string", paramType = "path", defaultValue = "test_key"), })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@DeleteMapping(value = "/del/str/{key}")
	public Map<String, Object> delStr(@PathVariable String key) {
		Map<String, Object> obj = new HashMap<String, Object>();

		if (redisService.del(key)) {
			obj.put("code", "100200");
			obj.put("msg", "success");
			obj.put("data", "");
		} else {
			obj.put("code", "100104");
			obj.put("msg", "fail del redis key");
			obj.put("data", "");
		}
		return obj;
	}

	@ApiOperation("redis에서 해당key의 value를 리턴한다.")
	@ApiImplicitParams({ @ApiImplicitParam(name = "key", value = "조회할 key 값", required = true, dataType = "string", paramType = "path", defaultValue = "test_key"), })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@GetMapping(value = "/get/obj/{key}")
	public Map<String, Object> getObj(@PathVariable String key) {
		Map<String, Object> obj = new HashMap<String, Object>();

		String result = redisService.get(key);
		HumanInfo humanInfo = new Gson().fromJson(result, HumanInfo.class);

		obj.put("code", "100200");
		obj.put("msg", "success");
		obj.put("data", humanInfo);
		return obj;
	}

	@ApiOperation("redis에 key의 value를 저장한다.")
	@ApiImplicitParams({ @ApiImplicitParam(name = "key", value = "저장할 key 값", required = true, dataType = "string", paramType = "path", defaultValue = "test_key"), })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@PostMapping(value = "/set/obj/{key}")
	public Map<String, Object> setObj(@PathVariable String key, @ApiParam(name = "param", value = "추가할 사용자 정보", required = true) @RequestBody HumanInfo param) {
		Map<String, Object> obj = new HashMap<String, Object>();

		Gson gson = new Gson();
		String value = gson.toJson(param);

		try {
			redisService.set(key, value);
			obj.put("code", "100200");
			obj.put("msg", "success");
			obj.put("data", "");
		} catch (Exception e) {
			log.error(e.getMessage());
			obj.put("code", "100104");
			obj.put("msg", "fail set redis key");
			obj.put("data", "");
		}
		return obj;
	}

	@ApiOperation("redis에서 해당key의 value를 삭제한다.")
	@ApiImplicitParams({ @ApiImplicitParam(name = "key", value = "삭제할 key 값", required = true, dataType = "string", paramType = "path", defaultValue = "test_key"), })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@DeleteMapping(value = "/del/obj/{key}")
	public Map<String, Object> delObj(@PathVariable String key) {
		Map<String, Object> obj = new HashMap<String, Object>();

		if (redisService.del(key)) {
			obj.put("code", "100200");
			obj.put("msg", "success");
			obj.put("data", "");
		} else {
			obj.put("code", "100104");
			obj.put("msg", "fail del redis key");
			obj.put("data", "");
		}
		return obj;
	}

	@ApiOperation("redis에서 모든 값을 리턴한다.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@GetMapping(value = "/getAll")
	public Map<String, Object> getAll() {
		Map<String, Object> obj = new HashMap<String, Object>();

		Map<String, Object> data = redisService.getAll();

		obj.put("code", "100200");
		obj.put("msg", "success");
		obj.put("data", data);
		return obj;
	}

}
