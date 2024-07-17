package com.comcast.crm.generic.JSONUtility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class JsonUtility {

	public String getDataFromJsonFile(String Key) throws Throwable
	{
		//get the java representation of json file
		FileReader fileReader = new FileReader("./ConfigData/jsondata.json");
		JSONParser jsonParser = new JSONParser();
		
		//Convert into Map Object to get the value and fetch the key
		Object obj = jsonParser.parse(fileReader);
		
		//Downcasting from the object class into JsonObject class
		JSONObject map = (JSONObject) obj;
		
		//Using the get("K") and get the data
		String data= (String)map.get(Key);
		
		return data ;
	}
}
