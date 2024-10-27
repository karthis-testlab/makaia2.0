package com.makaia.servicenow.api.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UiBankLoginService {
	
	private String host = "https://uibank-api.azurewebsites.net/api/";
	private Response response;
	
	public void createAuthToken() {
		String payload = "{\r\n"
				+ "    \"username\": \"FebApiuser\",\r\n"
				+ "    \"password\": \"Eagle@123\"\r\n"
				+ "}";
		response = RestAssured.given()
		           .header("Content-Type", "application/json")
		           .when()
		           .body(payload)
		           .post(host+"users/login");
	}
	
	public String extractToken() {
		return response.then()
		        .extract()
		        .jsonPath()
		        .getString("id");
	}
	
	public String extractUserId() {
		return response.then()
		        .extract()
		        .jsonPath()
		        .getString("userId");
	}

}