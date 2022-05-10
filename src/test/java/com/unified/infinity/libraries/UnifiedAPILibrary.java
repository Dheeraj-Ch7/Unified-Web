package com.unified.infinity.libraries;

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


public class UnifiedAPILibrary {
public static Response Response;
	
	public static Response get(Map<String, String> authheaders, String endPoint, String InputDataType, String InputData) {
		
		/******************************************************************************************************************
		 * Method Name: get
		 * Purpose: to return the response from API
		 * @param: authheaders, endPoint, InputDataType, InputData
		 * @output: Response
		 * @author Dheeraj
		 * @version 1.0
		 * @Date 08/10/2021
		 * ******************************************************************************************************************/
		
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
		/******************************************************************************************************************
		 * Method Name: post
		 * Purpose: to return the response from API
		 * @param: authheaders, endPoint, payLoad
		 * @output: Response
		 * @author Dheeraj
		 * @version 1.0
		 * @Date 08/10/2021
		 * ******************************************************************************************************************/
		
		Response = given().urlEncodingEnabled(false).request().headers(authheaders).body(payLoad).when().post(endPoint);
		
		return Response;
	}
	
	public static Response delete(Map<String, String> authheaders, String endPoint, String InputDataType, String InputData) {
		
		/******************************************************************************************************************
		 * Method Name: delete
		 * Purpose: to return the response from API
		 * @param: authheaders, endPoint, InputDataType, InputData
		 * @output: Response
		 * @author Dheeraj
		 * @version 1.0
		 * @Date 08/10/2021
		 * ******************************************************************************************************************/
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
	
	public static Response Call_API(Map<String, String> authheaders, String apiURL, String endPoint, String MethodType, String InputDataType, String InputData) {
		/******************************************************************************************************************
		 * Method Name: call
		 * Purpose: to return the response from API
		 * @param: authheaders, apiURL, endPoint, MethodType, InputDataType, InputData
		 * @output: Response
		 * @author Dheeraj
		 * @version 1.0
		 * @Date 08/10/2021
		 * ******************************************************************************************************************/
		switch(MethodType) {
		
		case "Get":
			Response = UnifiedAPILibrary.get(authheaders, apiURL, InputDataType, InputData);
			break;
		case "Post":
			Response = UnifiedAPILibrary.post(authheaders, apiURL, InputData);
			break;
		case "Delete":
			Response = UnifiedAPILibrary.delete(authheaders, apiURL, InputDataType, InputData);
			break;
		}
	
		return Response;
	}
}
