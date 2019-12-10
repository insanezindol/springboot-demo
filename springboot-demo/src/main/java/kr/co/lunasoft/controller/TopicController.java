package kr.co.lunasoft.controller;

import java.util.List;
import java.util.Optional;

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
import kr.co.lunasoft.jpa.TopicInfoRepository;
import kr.co.lunasoft.model.ResponseInfo;
import kr.co.lunasoft.model.TopicInfo;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/topic")
@Slf4j
@Api(tags = { "2. Topic" })
public class TopicController {
	
	@Autowired
	TopicInfoRepository topicInfoRepository;
	
	@ApiOperation("MySQL에서 topic table의 모든 데이터를 리턴한다.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@GetMapping(value = "/resource")
	public JSONObject list() {
		List<TopicInfo> list = topicInfoRepository.findAll();

		JSONObject obj = new JSONObject();
		obj.put("code", "100200");
		obj.put("msg", "success");
		obj.put("data", list);
		return obj;
	}
	
	@ApiOperation("MySQL에서 topic table의 특정 데이터(title 조건)를 조회한다.")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "title", value = "조회할 title 값", required = true, dataType = "string", paramType = "path", defaultValue = "테스트"), 
	})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@GetMapping(value = "/resource/title/{title}")
	public JSONObject getTitle(@PathVariable String title) {
		List<TopicInfo> list = topicInfoRepository.findAllByTitleLike("%"+title+"%");
		
		JSONObject obj = new JSONObject();
		obj.put("code", "100200");
		obj.put("msg", "success");
		obj.put("data", list);
		return obj;
	}
	
	@ApiOperation("MySQL에서 topic table의 특정 데이터(id 조건)를 조회한다.")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "조회할 id 값", required = true, dataType = "long", paramType = "path", defaultValue = "1"), 
	})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@GetMapping(value = "/resource/id/{id}")
	public JSONObject getId(@PathVariable long id) {
		Optional<TopicInfo> optionalPost = topicInfoRepository.findById(id);
		
		JSONObject obj = new JSONObject();
		obj.put("code", "100200");
		obj.put("msg", "success");
		TopicInfo info = null;
		if (optionalPost.isPresent()) {
			info = optionalPost.get();
		}
		obj.put("data", info);
		return obj;
	}
	
	@ApiOperation("MySQL에서 topic table에 데이터를 저장한다.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@PostMapping(value = "/resource")
	public JSONObject add(@ApiParam(name = "param", value = "추가할 정보", required = true) @RequestBody TopicInfo param) {
		topicInfoRepository.save(param);
		
		JSONObject output = new JSONObject();
		output.put("code", "100200");
		output.put("msg", "success");
		output.put("data", null);
		return output;
	}
	
	@ApiOperation("MySQL에서 topic table의 데이터를 수정한다.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@PutMapping(value = "/resource")
	public JSONObject modify(@ApiParam(name = "param", value = "수정할 정보", required = true) @RequestBody TopicInfo param) {
		int resultCnt = topicInfoRepository.updateTopicById(param);
		JSONObject output = new JSONObject();
		if (resultCnt > 0) {
			output.put("code", "100200");
			output.put("msg", "success");
			output.put("data", null);
		} else {
			output.put("code", "100103");
			output.put("msg", "error");
			output.put("data", null);
		}
		return output;
	}
	
	@ApiOperation("MySQL에서 topic table의 데이터를 삭제한다.")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "id", value = "삭제할 id 값", required = true, dataType = "long", paramType = "path", defaultValue = "1"), 
	})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@DeleteMapping(value = "/resource/{id}")
	public JSONObject delete(@PathVariable Long id) {
		topicInfoRepository.deleteById(id);

		JSONObject output = new JSONObject();
		output.put("code", "100200");
		output.put("msg", "success");
		output.put("data", null);
		
		return output;
	}
	
}
