package com.gmail.gimuniys.util;

import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class HttpUsageCall {
	
	public static String get(String path) {
		String result = "";
		try {
			HttpClient httpClient = HttpClientBuilder.create().build(); // HttpClient 생성
			HttpGet request = new HttpGet(path); //GET 메소드 URL 생성
			//getRequest.addHeader("x-api-key", RestTestCommon.API_KEY); //KEY 입력

			HttpResponse response = httpClient.execute(request);

			//Response 출력
			if (response.getStatusLine().getStatusCode() == 200) {
				ResponseHandler<String> handler = new BasicResponseHandler();
				result = handler.handleResponse(response);
				System.out.println(result);
			} else {
				System.out.println("response is error : " + response.getStatusLine().getStatusCode());
			}

		} catch (Exception e){
			System.err.println(e.toString());
		}
		
		return result;
	}
	
	
	public static JsonObject post(String path, Map<String, Object> params) {
		JsonObject result = null;
		
		try 
		{
			
			HttpClient httpClient = HttpClientBuilder.create().build(); // HttpClient 생성
			HttpPost request = new HttpPost(path); //POST 메소드 URL 새성 
			request.setHeader("Accept", "application/json");
			request.setHeader("Connection", "keep-alive");
			request.setHeader("Content-Type", "application/json; charset=utf-8");
			//postRequest.addHeader("x-api-key", RestTestCommon.API_KEY); //KEY 입력 
			//postRequest.addHeader("Authorization", token); // token 이용시

			StringEntity entity = new StringEntity(new Gson().toJson(params), "UTF-8");
			request.setEntity(entity); //json 메시지 입력 

			HttpResponse response = httpClient.execute(request);

			//Response 출력
			if (response.getStatusLine().getStatusCode() == 200) {
				ResponseHandler<String> handler = new BasicResponseHandler();
				String res = handler.handleResponse(response);
				result = new Gson().fromJson(res, JsonObject.class);
				//if(!result.isJsonNull() && result.getAsJsonObject("resultCode") == 200)
				//Map<String, Object> result = new Gson().fromJson(res, new TypeToken<HashMap<String, Object>>() {}.getType());
				
			} else {
				System.out.println("response is error : " + response.getStatusLine().getStatusCode());
			}
			
			
		} catch (Exception e){
			System.err.println(e.toString());
		}
		
		return result;
	}


}
