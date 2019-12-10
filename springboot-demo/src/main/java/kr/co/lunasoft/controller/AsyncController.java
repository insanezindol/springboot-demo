package kr.co.lunasoft.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import kr.co.lunasoft.model.ResponseInfo;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/async")
@Slf4j
@Api(tags = { "6. Async" })
public class AsyncController {
	
	@ApiOperation("비동기 작업을 호출하고 Callback 함수에서 후속작업을 진행한다.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@GetMapping(value = "/test1")
	public JSONObject test1() {
		// thenApply : 후속작업에 결과값 return 가능
		// thenAccept : 후속작업에 결과값 return 불가능
		log.info("test1 async start");
		CompletableFuture.supplyAsync(() -> this.buildMessage(1))
				.thenApply(finalResult -> printMessage("[thenApply] " + finalResult))
				.thenAccept(finalResult -> printMessage("[thenAccept] " + finalResult));
		log.info("test1 async end");

		JSONObject obj = new JSONObject();
		obj.put("code", "100200");
		obj.put("msg", "success");
		obj.put("data", null);
		return obj;
	}
	
	@ApiOperation("동시에 3개의 요청을 호출하고 개별로 진행한다.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@GetMapping(value = "/test2")
	public JSONObject test2() {

		// create new async task
		log.info("async start");
		CompletableFuture.supplyAsync(() -> this.buildMessage(2)).thenApply(finalResult -> printMessage("[thenApply] " + finalResult));
		CompletableFuture.supplyAsync(() -> this.buildMessage(3)).thenApply(finalResult -> printMessage("[thenApply] " + finalResult));
		CompletableFuture.supplyAsync(() -> this.buildMessage(4)).thenApply(finalResult -> printMessage("[thenApply] " + finalResult));
		log.info("async end");

		JSONObject obj = new JSONObject();
		obj.put("code", "100200");
		obj.put("msg", "success");
		obj.put("data", null);
		return obj;
	}
	
	@ApiOperation("동시에 3개의 요청을 호출하고 모든 호출이 완성되면 진행한다.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@GetMapping(value = "/test3")
	public JSONObject test3() {

		// create new async task
		log.info("async start");
		CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> this.buildMessage(5));
		CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> this.buildMessage(6));
		CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> this.buildMessage(7));
		log.info("async end");

		// lodge task
		List<CompletableFuture<String>> completableFutures = Arrays.asList(cf1, cf2, cf3);

		CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[3]))
				.thenApplyAsync(result -> completableFutures.stream().map(future -> future.join()).collect(Collectors.toList()))
				.thenAcceptAsync(messages -> messages.forEach(message -> log.info(message)));

		JSONObject obj = new JSONObject();
		obj.put("code", "100200");
		obj.put("msg", "success");
		obj.put("data", null);
		return obj;
	}
	
	@ApiOperation("동시에 3개의 요청을 호출하고 하나라도 호출이 완성되면 진행한다.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = ResponseInfo.class) })
	@GetMapping(value = "/test4")
	public JSONObject test4() {

		// create new async task
		log.info("async start");
		CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> this.buildMessage(8));
		CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> this.buildMessage(9));
		CompletableFuture<String> cf3 = CompletableFuture.supplyAsync(() -> this.buildMessage(0));
		log.info("async end");

		// lodge task
		List<CompletableFuture<String>> completableFutures = Arrays.asList(cf1, cf2, cf3);
		
		CompletableFuture.anyOf(completableFutures.toArray(new CompletableFuture[3]))
				.thenAcceptAsync(result -> this.printMessage(result.toString()));
		
		JSONObject obj = new JSONObject();
		obj.put("code", "100200");
		obj.put("msg", "success");
		obj.put("data", null);
		return obj;
	}

	@Description("5~10초 사이의 랜덤 초 생성후 Thread.sleep 후 return 한다.")
	private String buildMessage(int idx) {
		int rand =  new Random().nextInt(6) + 5;
		try {
			log.info("[" + idx + "] intValue : " + rand);
			Thread.sleep(rand * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "[" + idx + "] Completed + " + rand + "sec";
	}

	@Description("인자로 메시지를 받아오고 출력해준다.")
	private String printMessage(String msg) {
		log.info("printMessage : " + msg);
		return msg;
	}

}
