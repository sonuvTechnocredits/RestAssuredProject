package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.UserProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateUserProfileTest {
	
	@Test
	public void updateProfileTest() {
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("sonuvyavahare2021", "Sonu@#20081991"));
		LoginResponse loginResponse = response.as(LoginResponse.class); 
		System.out.println(response.asPrettyString());
		
		System.out.println("--------------------------------------------------------------------");
		
		UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
		response = userProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(), "sonuvyavahare2021");
		
		System.out.println("--------------------------------------------------------------------");
		
		UserProfileRequest userProfileRequest = new UserProfileRequest.Builder()
				.firstName("Sonu")
				.lastName("Vyavahare")
				.email("sonuvyavahare2021@gmail.com")
				.mobileNumber("9730097994")
				.build();
		response = userProfileManagementService.updateProfile(loginResponse.getToken(), userProfileRequest);
		System.out.println(response.asPrettyString());
	}

}
