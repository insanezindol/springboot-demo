package kr.co.lunasoft.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ElasticApi {

	@Value("${elasticsearch.host}")
	private String HOST;

	@Value("${elasticsearch.port}")
	private int PORT;

	/**
	 * 엘라스틱서치에서 제공하는 api를 이용한 전송 메소드 (동기)
	 * 
	 * @param method
	 * @param url
	 * @param obj
	 * @return
	 */
	public Map<String, Object> callElasticApi(String method, String url, Object obj) {
		Map<String, Object> result = new HashMap<>();

		// object to string
		Gson gson = new Gson();
		String jsonString = gson.toJson(obj);

		RestClient restClient = null;
		try {
			restClient = RestClient.builder(new HttpHost(HOST, PORT, "http")).build();

			Request request = new Request(method, url);

			if (method.equals("GET") || method.equals("DELETE")) {
				// GET, DELETE 메소드는 HttpEntity가 필요없다
			} else {
				HttpEntity entity = new NStringEntity(jsonString, ContentType.APPLICATION_JSON);
				request.setEntity(entity);
			}

			Response response = restClient.performRequest(request);

			int statusCode = response.getStatusLine().getStatusCode();
			String responseBody = EntityUtils.toString(response.getEntity());

			log.info("[" + statusCode + "] : " + responseBody);

			result.put("resultCode", statusCode);
			result.put("resultBody", responseBody);
		} catch (Exception e) {
			result.put("resultCode", -1);
			result.put("resultBody", e.toString());
			log.error("[E01] " + e.toString());
		} finally {
			try {
				restClient.close();
			} catch (Exception e) {
				log.error("[E02] " + e.toString());
			}
		}

		return result;
	}

}
