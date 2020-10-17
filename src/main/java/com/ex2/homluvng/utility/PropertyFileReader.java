package com.ex2.homluvng.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	
	
	static Properties prop=new Properties();
	
	public PropertyFileReader() {
		try {
			FileReader file=new FileReader(new File("./Config.properties"));
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static String getProperty(String propertyName) {
		try {
			FileReader file=new FileReader(new File("./Config.properties"));
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(propertyName);
		
	}
	
	public void setPropertyValue(String propertyName,String propertyValue) {
		try {
			FileReader file=new FileReader(new File("./Config.properties"));
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop.setProperty(propertyName, propertyValue);
	}
	
}
