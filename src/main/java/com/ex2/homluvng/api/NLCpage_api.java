package com.ex2.homluvng.api;

import java.util.List;

import org.testng.annotations.Test;

import com.ex2.homluvng.base.BaseClass;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NLCpage_api extends BaseClass {

	private Response getListOfData(String category,String pageNo) {
		getBaseURI();
		Response response;
		String path = null;
		if(category.equalsIgnoreCase("viewall")) {
			path="articles?pagesize=16&page="+pageNo;
		}
		else if(category.equalsIgnoreCase("trends")) {
			path="category?pagesize=16&page="+pageNo+"&category=trends";
		}else if(category.equalsIgnoreCase("advice")) {
			path="category?pagesize=16&page="+pageNo+"&category=advice";
		}else if(category.equalsIgnoreCase("relationships")) {
			path="category?pagesize=16&page="+pageNo+"&category=relationships";
		}else if(category.equalsIgnoreCase("inspiration")) {
			path="category?pagesize=16&page="+pageNo+"&category=inspiration";
		}else if(category.equalsIgnoreCase("lifestyle")) {
			path="category?pagesize=16&page="+pageNo+"&category=lifestyle";
		}
		response = RestAssured
				.given()
				.when()
				.get("/api/nlc/"+path);
		response.jsonPath();
		return response;
	}

	@Test
	public void checking() {
	//	Response listOfData = getListOfData("1");
	//	listOfData.getBody().jsonPath().getList("$");
//		System.out.println(listOfData.jsonPath().getList("$").size());
//		System.out.println(listOfData.jsonPath().getString("title"));
//		System.out.println(getListOfTitles("1"));
	}
	
	public List<String> getListOfTitles(String category,String pageNo) {
		Response responseData = getListOfData(category, pageNo);
		List<String> list = responseData.getBody().jsonPath().getList("title");
		return list;
	}
	
	public List<String> getListOfTeasers(String category,String pageNo){
		Response responseData = getListOfData(category, pageNo);
		List<String> list = responseData.getBody().jsonPath().getList("teaser");
		return list;
	}
	
	public List<String> getListOfUrlTitles(String category,String pageNo){
		Response responseData = getListOfData(category, pageNo);
		List<String> list = responseData.getBody().jsonPath().getList("urlTitle");
		return list;
	}
	
	public List<String> getListOfAuthors(String category,String pageNo){
		Response responseData = getListOfData(category,pageNo);
		List<String> list = responseData.getBody().jsonPath().getList("author");
		return list;
	}

}
