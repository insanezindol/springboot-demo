package kr.co.lunasoft.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.co.lunasoft.model.ResponseInfo;
import kr.co.lunasoft.service.KafkaService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/kafka")
@Slf4j
@Api(tags = { "4. Kafka" })
public class KafkaController {
	
	@Autowired
    private KafkaService kafkaService;

	@ApiOperation("topic과 message를 parameter로 전달받아 kafka로 발송한다.")
	@ApiImplicitParams({ 
		@ApiImplicitParam(name = "topic", value = "kafka로 발송할 topic", required = true, dataType = "string", paramType = "path", defaultValue = "dean"), 
		@ApiImplicitParam(name = "message", value = "kafka로 발송할 message", required = true, dataType = "string", paramType = "path", defaultValue = "cool"), 
	})
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
    @GetMapping(value = "/send/{topic}/{message}")
    public JSONObject send(@PathVariable String topic, @PathVariable String message) {
    	
    	kafkaService.send(topic, message);
    	
        JSONObject obj = new JSONObject();
        obj.put("code", "100200");
        obj.put("msg", "success");
        obj.put("data", null);
        return obj;
    }

}
