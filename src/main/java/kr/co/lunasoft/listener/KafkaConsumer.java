package kr.co.lunasoft.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class KafkaConsumer {

	@KafkaListener(topics = "test")
	public void receiveTestTopic(String payload) {
		log.info("[TEST] received payload='{}'", payload);
	}

	@KafkaListener(topics = "dean")
	public void receiveDeanTopic(String payload) {
		log.info("[DEAN] received payload='{}'", payload);
	}

}
