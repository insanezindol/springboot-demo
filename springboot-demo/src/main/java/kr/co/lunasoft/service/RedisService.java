package kr.co.lunasoft.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Slf4j
@Service
public class RedisService {

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	@Resource(name="redisTemplate")
	private ValueOperations<String, String> valueOperations;

	@Resource(name="redisTemplate")
	private SetOperations<String, String> setOperations;

	@Resource(name="redisTemplate")
	private HashOperations<String, String, String> hashOperations;

	public String get(String key) {
		return valueOperations.get(key);
	}

	public void set(String key, String value) {
		valueOperations.set(key, value);
	}

	public Boolean del(String key) {
		return redisTemplate.delete(key);
	}

	public Map<String, Object> getAll() {
		Set<String> redisKeys = redisTemplate.keys("*");
		Map<String, Object> map = new Hashtable<String, Object>();
		Iterator<String> it = redisKeys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			String type = redisTemplate.type(key).toString();

			if(!key.contains("teletalk:session")) {
				try {
					if (type.equals("STRING")) {
						map.put(key, valueOperations.get(key));
					} else if (type.equals("HASH")) {
						map.put(key, hashOperations.entries(key));
					} else if (type.equals("SET")) {
						map.put(key, setOperations.members(key));
					} else {
						log.error("unknown type : {} : {}", key, redisTemplate.type(key));
					}
				} catch (Exception e) {
					log.error("{} : {} : {}", key, redisTemplate.type(key), e.getMessage());
				}
			} else {
				log.info("[{}] {}", redisTemplate.type(key), key);
			}

		}
		return map;
	}
}