package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {
	
	public String getDataFromJsonFile(String key) throws Throwable {
		FileReader fisR =  new FileReader("C:\\Users\\Shivani\\eclipse-workspace\\ComcastCRMGUIFramework\\configAppData\\appCommanData.json");
		JSONParser parse = new JSONParser();
		Object obj =  parse.parse(fisR);
		JSONObject map = (JSONObject) obj;
		String data = (String) map.get(key);
		return data;
		
		
	}
	
	
	
	

}
