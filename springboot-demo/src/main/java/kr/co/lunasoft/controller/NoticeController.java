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
import kr.co.lunasoft.model.NoticeInfo;
import kr.co.lunasoft.model.ResponseInfo;
import kr.co.lunasoft.service.NoticeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/notice")
@Slf4j
@Api(tags = { "1. Notice" })
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@ApiOperation("MySQL에서 notice table의 모든 데이터를 리턴한다.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@GetMapping(value = "/resource")
	public Map<String, Object> list() {
		List<NoticeInfo> list = noticeService.getList();

		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("code", "100200");
		obj.put("msg", "success");
		obj.put("data", list);
		return obj;
	}

	@ApiOperation("MySQL에서 notice table의 특정 데이터를 리턴한다.")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "조회할 id 값", required = true, dataType = "string", paramType = "path", defaultValue = "1"), 
	})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@GetMapping(value = "/resource/{id}")
	public Map<String, Object> get(@PathVariable String id) {
		NoticeInfo param = new NoticeInfo();
		param.setId(id);
		NoticeInfo info = noticeService.getOne(param);

		Map<String, Object> obj = new HashMap<String, Object>();
		if (info == null) {
			obj.put("code", "100103");
			obj.put("msg", "object not exist");
			obj.put("data", null);
		} else {
			obj.put("code", "100200");
			obj.put("msg", "success");
			obj.put("data", info);
		}
		return obj;
	}

	@ApiOperation("MySQL에서 notice table에 데이터를 저장한다.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@PostMapping(value = "/resource")
	public Map<String, Object> add(@ApiParam(name = "param", value = "추가할 정보", required = true) @RequestBody NoticeInfo param) {
		int resultCnt = noticeService.addNotice(param);
		Map<String, Object> obj = new HashMap<String, Object>();
		if (resultCnt == 1) {
			obj.put("code", "100200");
			obj.put("msg", "success");
		} else {
			obj.put("code", "100103");
			obj.put("msg", "error");
		}
		return obj;
	}

	@ApiOperation("MySQL에서 notice table의 데이터를 수정한다.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@PutMapping(value = "/resource")
	public Map<String, Object> modify(@ApiParam(name = "param", value = "수정할 정보", required = true) @RequestBody NoticeInfo param) {
		int resultCnt = noticeService.modifyNotice(param);
		Map<String, Object> obj = new HashMap<String, Object>();
		if (resultCnt == 1) {
			obj.put("code", "100200");
			obj.put("msg", "success");
		} else {
			obj.put("code", "100103");
			obj.put("msg", "error");
		}
		return obj;
	}

	@ApiOperation("MySQL에서 notice table의 데이터를 삭제한다.")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "삭제할 id 값", required = true, dataType = "string", paramType = "path", defaultValue = "1"), 
	})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@DeleteMapping(value = "/resource/{id}")
	public Map<String, Object> delete(@PathVariable String id) {
		NoticeInfo param = new NoticeInfo();
		param.setId(id);
		int resultCnt = noticeService.removeNotice(param);

		Map<String, Object> obj = new HashMap<String, Object>();
		if (resultCnt == 1) {
			obj.put("code", "100200");
			obj.put("msg", "success");
		} else {
			obj.put("code", "100103");
			obj.put("msg", "error");
		}
		return obj;
	}

}
