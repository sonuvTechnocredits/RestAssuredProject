package testScript;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class RestAssuredAPI {
		//TCS site --  //https://groww.in/stocks/tata-consultancy-services-ltd
	public static void main(String[] args) {
		
		//Way1
		/*RestAssured.baseURI = "https://groww.in/v1/api/charting_service/v2/chart/delayed/exchange/NSE/segment/CASH/TCS/daily?intervalInMinutes=1&minimal=true";
		RequestSpecification requestSpec = RestAssured.given();
		Response response = requestSpec.get();
		System.out.println(response.prettyPrint()); */

		
		//Way2
		/*RestAssured.baseURI = "https://groww.in/v1/api/charting_service/v2/chart/delayed/exchange/NSE/segment/CASH/TCS/daily?intervalInMinutes=1&minimal=true";
		RequestSpecification requestSpec = RestAssured.given();
		Response response = requestSpec.request(Method.GET);
		System.out.println(response.prettyPrint()); */
			
		
		//Way3 - DSL - Domain Specific Language
			
		given()
		.when()
			.get("https://groww.in/v1/api/charting_service/v2/chart/delayed/exchange/NSE/segment/CASH/TCS/daily?intervalInMinutes=1&minimal=true")
		.then()
		.log().all();
		
	}

}
