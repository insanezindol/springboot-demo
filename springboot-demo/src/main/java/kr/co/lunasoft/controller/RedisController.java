package kr.co.lunasoft.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.lunasoft.service.RedisService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {
	
	@Autowired
    private RedisService redisService;

    @GetMapping(value = "/get/{key}")
    public JSONObject get(@PathVariable String key) {
        JSONObject obj = new JSONObject();

        obj.put("code", "100200");
        obj.put("msg", "success");
        obj.put("data", redisService.get(key));
        return obj;
    }

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
