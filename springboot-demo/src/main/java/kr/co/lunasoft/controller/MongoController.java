package kr.co.lunasoft.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import kr.co.lunasoft.model.HumanInfo;
import kr.co.lunasoft.model.ResponseInfo;
import kr.co.lunasoft.service.MongoService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/mongo")
@Slf4j
@Api(tags = { "3. MongoDB" })
public class MongoController {

	@Autowired
	MongoService mongoService;

	@ApiOperation("MongoDB에서 user Collection의 모든 데이터를 리턴한다.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@GetMapping(value = "/resource")
	public Map<String, Object> list() {
		List<HumanInfo> list = mongoService.getList();

		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("code", "100200");
		obj.put("msg", "success");
		obj.put("data", list);
		return obj;
	}

	@ApiOperation("MongoDB에서 user Collection의 name 값을 조회하여 리턴한다.")
	@ApiImplicitParams({ @ApiImplicitParam(name = "name", value = "조회할 name 값", required = true, dataType = "string", paramType = "path", defaultValue = "jhlee"), })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@GetMapping(value = "/resource/{name}")
	public Map<String, Object> get(@PathVariable String name) {
		HumanInfo info = mongoService.getOne(name);

		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("code", "100200");
		obj.put("msg", "success");
		obj.put("data", info);
		return obj;
	}

	@ApiOperation("MongoDB에서 user Collection의 값을 추가한다.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@PostMapping(value = "/resource")
	public Map<String, Object> save(@ApiParam(name = "param", value = "추가할 사용자 정보", required = true) @RequestBody HumanInfo param) {
		mongoService.add(param);

		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("code", "100200");
		obj.put("msg", "success");
		return obj;
	}

	@ApiOperation("MongoDB에서 user Collection의 id 값을 기준으로 수정한다.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@PutMapping(value = "/resource")
	public Map<String, Object> modify(@ApiParam(name = "param", value = "수정할 사용자 정보", required = true) @RequestBody HumanInfo param) {
		mongoService.modify(param);

		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("code", "100200");
		obj.put("msg", "success");
		return obj;
	}

	@ApiOperation("MongoDB에서 user Collection의 id 값을 기준으로 삭제한다.")
	@ApiImplicitParams({ @ApiImplicitParam(name = "id", value = "삭제할 id 값", required = true, dataType = "string", paramType = "path", defaultValue = "1"), })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@DeleteMapping(value = "/resource/{id}")
	public Map<String, Object> delete(@PathVariable String id) {
		mongoService.delete(id);

		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("code", "100200");
		obj.put("msg", "success");
		return obj;
	}

}
