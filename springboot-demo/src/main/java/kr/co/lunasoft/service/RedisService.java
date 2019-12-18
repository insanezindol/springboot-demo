package kr.co.lunasoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	public String get(String key) {
		ValueOperations<String, String> vop = stringRedisTemplate.opsForValue();
		return vop.get(key);
	}

	public void set(String key, String value) {
		ValueOperations<String, String> vop = stringRedisTemplate.opsForValue();
		vop.set(key, value);
	}

	public Boolean del(String key) {
		return stringRedisTemplate.delete(key);
	}

}