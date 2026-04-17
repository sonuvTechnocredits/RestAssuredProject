package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

public class AccountCreationTest {
	
	@Test(description = "Verify if SignUp API is working...")
	public void createAccountTest() {
		SignUpRequest signUpRequest = new SignUpRequest.Builder()
		.userName("GokulBS")
		.email("sonu12345@gmail.123")
		.firstName("SonuS")
		.lastName("GSawale")
		.password("sonu123")
		.mobileNumber("7788996655")
		.build();
		
		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpRequest);
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
	}
	

}
