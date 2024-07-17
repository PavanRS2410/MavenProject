package com.comcast.crm.generic.fileutility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility 
{

	public String getDataFromPropFile(String Key) throws Throwable
	{
		File f = new File("./ConfigData/DDT_config.properties");
		FileInputStream fileInputStream = new FileInputStream(f);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String data = properties.getProperty(Key);
		return data;
	}
}
