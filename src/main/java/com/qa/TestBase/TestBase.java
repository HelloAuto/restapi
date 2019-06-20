package com.qa.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	
	public Properties prop;
	
	public TestBase() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\91890\\eclipse-workspace\\restapi\\src\\main\\java\\com\\qa\\config\\config.properties");
		prop.load(fis);
	}
	

}
