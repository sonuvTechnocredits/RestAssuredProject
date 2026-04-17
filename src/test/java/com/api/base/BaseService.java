package com.api.base;

import static io.restassured.RestAssured.given;

import com.api.filters.LoggingFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {  //Wrapper for Rest Assured
	//BaseUri
	//Creating the request
	//Handling the response
	
	private static final String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	
	static {
		RestAssured.filters(new LoggingFilter());
	}
	
	public BaseService() {
		requestSpecification = given().baseUri(BASE_URL); 
	}
	
	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization", "Bearer " + token);
	}
	
	protected Response postRequest(Object payload, String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endPoint);
	}
	
	protected Response putRequest(Object payload, String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endPoint);
	}
	
	protected Response getRequest(String endPoint) {
		return requestSpecification.get(endPoint);
	}
	
	protected Response postRequest(String baseUri, Object payload, String endPoint) {
		return requestSpecification.baseUri(baseUri).contentType(ContentType.JSON).body(payload).post(endPoint);
	}
	
}
