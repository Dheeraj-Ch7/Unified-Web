package com.unified.infinity.uitest.admin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Add_Live_Class_API {

	public static Response Response;
	
	public static Response get(Map<String, String> authheaders, String endPoint, String InputDataType, String InputData) {
		
		switch(InputDataType) {
			case "None":
				Response = given().urlEncodingEnabled(false).request().headers(authheaders).get(endPoint).andReturn();
				break;
			case "URLEncoded":
				endPoint = endPoint + InputData;
				Response = given().urlEncodingEnabled(false).request().headers(authheaders).get(endPoint).andReturn();
				break;
			case "PayLoad":
				Response = given().urlEncodingEnabled(false).request().headers(authheaders).body(InputData).get(endPoint).andReturn();
				break;
		}
		return Response;
	}
	
	public static Response post(Map<String, String> authheaders, String endPoint, String payLoad) {
		
		Response = given().urlEncodingEnabled(false).request().headers(authheaders).body(payLoad).when().post(endPoint);
		
		return Response;
	}
	
	public static Response delete(Map<String, String> authheaders, String endPoint, String InputDataType, String InputData) {
		
		switch(InputDataType) {
			case "None":
				Response = given().urlEncodingEnabled(false).request().headers(authheaders).delete(endPoint).andReturn();
				break;
			case "URLEncoded":
//				endPoint = endPoint + InputData;
				Response = given().urlEncodingEnabled(false).request().headers(authheaders).delete(endPoint).andReturn();
				break;
			case "PayLoad":
				Response = given().urlEncodingEnabled(false).request().headers(authheaders).body(InputData).delete(endPoint).andReturn();
				break;
		}
		
		return Response;
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		
		String InputData = "";
		String APIEndPoint = "";
		String MethodType = "Post";
		String InputDataType = "None";
		
		String apiURL = "https://livestagingapi.devinfinitylearn.in/api/v1/eclasses";
//		String apiURL = "https://livestagingapi.devinfinitylearn.in/api/v1/eclasses/6115e870624cd5aa18b81bb9";
		
//		To read the value from notepad
		InputData = new Scanner(new File(System.getProperty("user.dir")+"\\TestData\\InputXML.txt")).useDelimiter("\\Z").next();
		
		Map<String, String> authheaders = new HashMap<String, String>();
//		authheaders.put("Authorization", "*/*");
		authheaders.put("Content-Type", "application/json; charset=utf-8");
		
		switch(MethodType) {
		
		case "Get":
			Response = get(authheaders, apiURL, InputDataType, InputData);
			break;
		case "Post":
			Response = post(authheaders, apiURL, InputData);
			break;
		case "Delete":
			Response = delete(authheaders, apiURL, InputDataType, InputData);
			break;
		}
		
		System.out.println("The Response Code is "+Response.getStatusCode());
		System.out.println("The Response Body is "+Response.asString());
		

	}
}
