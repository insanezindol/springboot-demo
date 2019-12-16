package kr.co.lunasoft.controller;

import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.co.lunasoft.model.DeptInfo;
import kr.co.lunasoft.model.ResponseInfo;
import kr.co.lunasoft.model.UserInfo;
import kr.co.lunasoft.util.ElasticApi;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/es")
@Slf4j
@Api(tags = { "9. ElasticSearch" })
public class ElasticSearchController {

	@Autowired
	ElasticApi elasticApi;

	@ApiOperation("ElasticSearch GET - 조회")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "index", value = "조회할 index 값", required = true, dataType = "string", paramType = "path", defaultValue = "lunasoft"), 
		@ApiImplicitParam(name = "type", value = "조회할 type 값", required = true, dataType = "string", paramType = "path", defaultValue = "dean"), 
		@ApiImplicitParam(name = "id", value = "조회할 id 값", required = true, dataType = "string", paramType = "path", defaultValue = "1"), 
		})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@GetMapping(value = "/{index}/{type}/{id}")
	public JSONObject getResource(@PathVariable String index, @PathVariable String type, @PathVariable String id) {
		String url = index + "/" + type + "/" + id;

		Map<String, Object> result = elasticApi.callElasticApi("GET", url, null);

		JSONObject obj = new JSONObject();
		obj.put("code", "100200");
		obj.put("msg", "success");
		obj.put("data", result);
		return obj;
	}

	@ApiOperation("ElasticSearch POST - key 없이 사용자 정보 전송 (insert)")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "index", value = "조회할 index 값", required = true, dataType = "string", paramType = "path", defaultValue = "lunasoft"), 
		@ApiImplicitParam(name = "type", value = "조회할 type 값", required = true, dataType = "string", paramType = "path", defaultValue = "dean"), 
		})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@PostMapping(value = "/user/{index}/{type}")
	public JSONObject postUserInfoResource(@PathVariable String index, @PathVariable String type, @ApiParam(name = "userInfo", value = "추가할 사용자 정보", required = true) @RequestBody UserInfo userInfo) {
		String url = index + "/" + type;

		Map<String, Object> result = elasticApi.callElasticApi("POST", url, userInfo);

		JSONObject obj = new JSONObject();
		obj.put("code", "100200");
		obj.put("msg", "success");
		obj.put("data", result);
		return obj;
	}
	
	@ApiOperation("ElasticSearch POST - key 없이 부서 정보 전송 (insert)")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "index", value = "조회할 index 값", required = true, dataType = "string", paramType = "path", defaultValue = "lunasoft-sub1"), 
		@ApiImplicitParam(name = "type", value = "조회할 type 값", required = true, dataType = "string", paramType = "path", defaultValue = "dept"), 
		})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@PostMapping(value = "/dept/{index}/{type}")
	public JSONObject postDeptInfoResource(@PathVariable String index, @PathVariable String type, @ApiParam(name = "deptInfo", value = "추가할 부서 정보", required = true) @RequestBody DeptInfo deptInfo) {
		String url = index + "/" + type;

		Map<String, Object> result = elasticApi.callElasticApi("POST", url, deptInfo);

		JSONObject obj = new JSONObject();
		obj.put("code", "100200");
		obj.put("msg", "success");
		obj.put("data", result);
		return obj;
	}

	@ApiOperation("ElasticSearch PUT - key 함께 사용자 정보 전송 (upsert)")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "index", value = "조회할 index 값", required = true, dataType = "string", paramType = "path", defaultValue = "lunasoft"), 
		@ApiImplicitParam(name = "type", value = "조회할 type 값", required = true, dataType = "string", paramType = "path", defaultValue = "dean"), 
		@ApiImplicitParam(name = "id", value = "조회할 id 값", required = true, dataType = "string", paramType = "path", defaultValue = "1"), 
		})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@PutMapping(value = "/user/{index}/{type}/{id}")
	public JSONObject putResource(@PathVariable String index, @PathVariable String type, @PathVariable String id, @ApiParam(name = "userInfo", value = "추가할 사용자 정보", required = true) @RequestBody UserInfo userInfo) {
		String url = index + "/" + type + "/" + id;

		Map<String, Object> result = elasticApi.callElasticApi("PUT", url, userInfo);

		JSONObject obj = new JSONObject();
		obj.put("code", "100200");
		obj.put("msg", "success");
		obj.put("data", result);
		return obj;
	}

	@ApiOperation("ElasticSearch DELETE - index, type, id로 해당 정보 삭제")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "index", value = "조회할 index 값", required = true, dataType = "string", paramType = "path", defaultValue = "lunasoft"), 
		@ApiImplicitParam(name = "type", value = "조회할 type 값", required = true, dataType = "string", paramType = "path", defaultValue = "dean"), 
		@ApiImplicitParam(name = "id", value = "조회할 id 값", required = true, dataType = "string", paramType = "path", defaultValue = "1"), 
		})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@DeleteMapping(value = "/{index}/{type}/{id}")
	public JSONObject deleteResource(@PathVariable String index, @PathVariable String type, @PathVariable String id) {
		String url = index + "/" + type + "/" + id;

		Map<String, Object> result = elasticApi.callElasticApi("DELETE", url, null);

		JSONObject obj = new JSONObject();
		obj.put("code", "100200");
		obj.put("msg", "success");
		obj.put("data", result);
		return obj;
	}

}
