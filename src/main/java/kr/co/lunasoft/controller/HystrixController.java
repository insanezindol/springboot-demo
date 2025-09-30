package kr.co.lunasoft.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.co.lunasoft.model.ResponseInfo;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/hystrix")
@Slf4j
@Api(tags = { "7. Hystrix" })
public class HystrixController {
	
	@ApiOperation("시간 오래 걸리는 연산 실행하여 fallbackMethod에서 리턴하는지 확인한다.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@GetMapping(value = "/timeout")
	@HystrixCommand(commandKey="hystrix-test", fallbackMethod = "test_fallback", commandProperties= {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds", value = "500")})
    public Map<String, Object> timeout() {
		// 시간 오래 걸리는 연산 실행
		log.info("[BEG] test");
		BigDecimal bd = new BigDecimal("0");
		for(int i=0; i<100000000; i++) {
			bd.add(new BigDecimal(i));
		}
		log.info("[END] test");
		
		Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("code", "100200");
        obj.put("msg", "success");
        obj.put("data", "");
        return obj;
    }
	
	@Description("timeout 함수가 500ms 이상 걸리면 test_fallback 함수가 실행되고 리턴한다.")
	public Map<String, Object> test_fallback(Throwable t) {
		Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("code", "300200");
        obj.put("msg", "fallback error");
        obj.put("data", "");
        return obj;
	}

}
