package com.api.test;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class LoginAPITest2 {
	
	@Test(description = "Verify if Login API is working.")
	public void loginTest() {
		Response response = given()
							.baseUri("http://64.227.160.186:8080")
							.header("Content-Type","application/json" )
							.body("{\r\n"
								+ "  \"username\": \"sonuvyavahare2021\",\r\n"
								+ "  \"password\": \"Sonu@#20081991\"\r\n"
								+ "}")
							.post("/api/auth/login");
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
