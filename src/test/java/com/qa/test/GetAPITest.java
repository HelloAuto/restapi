package com.qa.test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.TestBase.TestBase;
import com.qa.client.RestClient;

public class GetAPITest extends TestBase{
	TestBase testBase;
	String URL;
	String serviceURL;
	String URI;
	RestClient restClient;
	
	public GetAPITest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		testBase = new TestBase();
		URL = prop.getProperty("URL");
		serviceURL = prop.getProperty("serviceURL");
		
		URI = URL + serviceURL;
		
	}
	
	@Test
	public void getTest() throws IOException {
		restClient = new RestClient();
		restClient.get(URI);
		
	}

	
}
