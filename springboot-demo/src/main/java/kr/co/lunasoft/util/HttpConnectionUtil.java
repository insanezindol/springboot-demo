package kr.co.lunasoft.util;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpConnectionUtil {
	
	public static String sendGet(String serverUrl, List<NameValuePair> parameters) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
	    
		String result = "fail";
		CloseableHttpResponse response = null;

		try {
			URIBuilder uriBuilder = new URIBuilder(serverUrl);
		    uriBuilder.addParameters(parameters);

		    HttpGet httpGet = new HttpGet(uriBuilder.build());
		    
		    httpGet.setHeader("Content-Type", "application/json; charset=utf-8");
			response = httpClient.execute(httpGet);

			int responseCode = response.getStatusLine().getStatusCode();
			String responseMessage = response.getStatusLine().getReasonPhrase();

			log.info("Response Code ==>> {}, Response Message ==>> {}, reqRul ==>> {} ", responseCode, responseMessage, serverUrl);

			if (responseCode < 300) {
				HttpEntity responseEntity = response.getEntity();
				result = EntityUtils.toString(responseEntity);
			} else {
				throw new RuntimeException("Http is not Ok response Code : " + responseCode + " responseMessage : " + responseMessage);
			}
		} catch (Exception e) {
			log.info("Connection Error " + e.getMessage());
		} finally {
			try {
				response.close();
			} catch (Exception e) {
			}
			try {
				httpClient.close();
			} catch (Exception e) {
			}
		}

		return result;
	}
	
	public static String sendPost(String serverUrl, List<NameValuePair> parameters) {
		CloseableHttpClient httpClient = HttpClients.createDefault();
	    
		String result = "fail";
		CloseableHttpResponse response = null;

		try {
			URIBuilder uriBuilder = new URIBuilder(serverUrl);
		    uriBuilder.addParameters(parameters);

		    HttpPost httpPost = new HttpPost(uriBuilder.build());
		    
			httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
			response = httpClient.execute(httpPost);

			int responseCode = response.getStatusLine().getStatusCode();
			String responseMessage = response.getStatusLine().getReasonPhrase();

			log.info("Response Code ==>> {}, Response Message ==>> {}, reqRul ==>> {} ", responseCode, responseMessage, serverUrl);

			if (responseCode < 300) {
				HttpEntity responseEntity = response.getEntity();
				result = EntityUtils.toString(responseEntity);
			} else {
				throw new RuntimeException("Http is not Ok response Code : " + responseCode + " responseMessage : " + responseMessage);
			}
		} catch (Exception e) {
			log.info("Connection Error " + e.getMessage());
		} finally {
			try {
				response.close();
			} catch (Exception e) {
			}
			try {
				httpClient.close();
			} catch (Exception e) {
			}
		}

		return result;
	}

}
