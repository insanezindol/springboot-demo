package kr.co.lunasoft.controller;

import java.util.List;

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

import kr.co.lunasoft.model.NoticeInfo;
import kr.co.lunasoft.service.NoticeService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/notice")
@Slf4j
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@GetMapping(value = "/resource")
	public JSONObject list() {
		List<NoticeInfo> list = noticeService.getList();

		JSONObject obj = new JSONObject();
		obj.put("code", "100200");
		obj.put("msg", "success");
		obj.put("data", list);
		return obj;
	}

	@GetMapping(value = "/resource/{id}")
	public JSONObject get(@PathVariable String id) {
		NoticeInfo param = new NoticeInfo();
		param.setId(id);
		NoticeInfo info = noticeService.getOne(param);

		JSONObject obj = new JSONObject();
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

	@PostMapping(value = "/resource")
	public JSONObject add(@RequestBody NoticeInfo param) {
		int resultCnt = noticeService.addNotice(param);
		JSONObject output = new JSONObject();
		if (resultCnt == 1) {
			output.put("code", "100200");
			output.put("msg", "success");
		} else {
			output.put("code", "100103");
			output.put("msg", "error");
		}
		return output;
	}

	@PutMapping(value = "/resource")
	public JSONObject modify(@RequestBody NoticeInfo param) {
		int resultCnt = noticeService.modifyNotice(param);
		JSONObject output = new JSONObject();
		if (resultCnt == 1) {
			output.put("code", "100200");
			output.put("msg", "success");
		} else {
			output.put("code", "100103");
			output.put("msg", "error");
		}
		return output;
	}

	@DeleteMapping(value = "/resource/{id}")
	public JSONObject delete(@PathVariable String id) {
		NoticeInfo param = new NoticeInfo();
		param.setId(id);
		int resultCnt = noticeService.removeNotice(param);

		JSONObject output = new JSONObject();
		if (resultCnt == 1) {
			output.put("code", "100200");
			output.put("msg", "success");
		} else {
			output.put("code", "100103");
			output.put("msg", "error");
		}
		return output;
	}

}
