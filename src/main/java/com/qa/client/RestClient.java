package com.qa.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	public void get(String uri) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		
		// Status Code
		int statusCode = httpResponse.getStatusLine().getStatusCode();
		System.out.println("Status Code is : "+statusCode);
		
		// JSON String
		String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
		JSONObject responseJSON = new JSONObject(responseString);
		System.out.println("Response JSON from API ::" +responseJSON);
		
		// All Headers
		Header[] headers = httpResponse.getAllHeaders();
		HashMap<String,String> allHeaders = new HashMap<String,String>();
		for(Header header : headers) {
			allHeaders.put(header.getName(), header.getValue());
		}
		
		System.out.println("Header are ::"+allHeaders);
	}

}
