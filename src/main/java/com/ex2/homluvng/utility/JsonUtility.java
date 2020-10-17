package com.ex2.homluvng.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {


	/**
	 * @author sagupta
	 * @param jsonFile -name of the json file
	 * @param rootKey -root key of the json  data
	 * @param Key -the key for which you want to get the data
	 * @return
	 */
	public static String getData(String jsonFile, String rootKey, String Key) {
		FileReader reader = null;
		String value = null;
		JSONParser parser = new JSONParser();
		try {
			reader = new FileReader(
					System.getProperty("user.dir") + "/src/test/resources/TestData/" + jsonFile + ".json");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Object obj = parser.parse(reader);
			JSONObject json = (JSONObject) obj;
			Map map = (Map)json.get(rootKey);
			value = (String)map.get(Key);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;
	}
	
	
	/**
	 * @author sagupta
	 * @param jsonFile
	 * @param rootKey
	 * @param Key
	 * @return
	 */
	public static int getListDataCount(String jsonFile,String rootKey,String Key) {

		FileReader reader = null;
		int dataCount=-1;

		JSONParser parser = new JSONParser();
		try {
			reader = new FileReader(
					System.getProperty("user.dir") + "/src/test/resources/TestData/" + jsonFile + ".json");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Object obj = parser.parse(reader);
			JSONObject json = (JSONObject) obj;
			Map map=(Map)json.get(rootKey);
			JSONArray array=(JSONArray)map.get(Key);
			dataCount=array.size();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	return dataCount;
		}
	
	/**
	 * @author sagupta
	 * @param jsonFile
	 * @param rootKey
	 * @param Key
	 * @return
	 */
	public  static ArrayList getAllData(String jsonFile,String rootKey,String Key)	{
		FileReader reader = null;
		ArrayList<String> data = new ArrayList<String>();

		JSONParser parser = new JSONParser();
		try {
			reader = new FileReader(
					System.getProperty("user.dir") + "/src/test/resources/TestData/" + jsonFile + ".json");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Object obj = parser.parse(reader);
			JSONObject json = (JSONObject) obj;
			Map map=(Map)json.get(rootKey);
			JSONArray jsonarray=(JSONArray)map.get(Key);
			for(int i=0;i<jsonarray.size();i++) {
				data.add(jsonarray.get(i).toString());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
