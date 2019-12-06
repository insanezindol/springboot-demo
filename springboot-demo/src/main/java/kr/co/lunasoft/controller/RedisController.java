package kr.co.lunasoft.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.co.lunasoft.model.ResponseInfo;
import kr.co.lunasoft.service.RedisService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/redis")
@Slf4j
@Api(tags = { "3. Redis" })
public class RedisController {
	
	@Autowired
    private RedisService redisService;

	@ApiOperation("redis에서 해당key의 value를 리턴한다.")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "key", value = "조회할 key 값", required = true, dataType = "string", paramType = "path", defaultValue = "test_key"), 
	})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
    @GetMapping(value = "/get/{key}")
    public JSONObject get(@PathVariable String key) {
        JSONObject obj = new JSONObject();

        obj.put("code", "100200");
        obj.put("msg", "success");
        obj.put("data", redisService.get(key));
        return obj;
    }

	@ApiOperation("redis에 key의 value를 저장한다.")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "key", value = "저장할 key 값", required = true, dataType = "string", paramType = "path", defaultValue = "test_key"),
		@ApiImplicitParam(name = "value", value = "저장할 value 값", required = true, dataType = "string", paramType = "path", defaultValue = "test_value"),
	})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
    @PostMapping(value = "/set/{key}/{value}")
    public JSONObject set(@PathVariable String key, @PathVariable String value) {
        JSONObject obj = new JSONObject();

        try {
            redisService.set(key, value);
            obj.put("code", "100200");
            obj.put("msg", "success");
            obj.put("data", null);
        } catch (Exception e) {
            log.error(e.getMessage());
            obj.put("code", "100104");
            obj.put("msg", "fail set redis key");
            obj.put("data", null);
        }
        return obj;
    }

	@ApiOperation("redis에서 해당key의 value를 삭제한다.")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "key", value = "삭제할 key 값", required = true, dataType = "string", paramType = "path", defaultValue = "test_key"), 
	})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
    @DeleteMapping(value = "/del/{key}")
    public JSONObject del(@PathVariable String key) {
        JSONObject obj = new JSONObject();

        if (redisService.del(key)) {
            obj.put("code", "100200");
            obj.put("msg", "success");
            obj.put("data", null);
        } else {
            obj.put("code", "100104");
            obj.put("msg", "fail del redis key");
            obj.put("data", null);
        }
        return obj;
    }

}
