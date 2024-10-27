package com.makaia.servicenow.api.services;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UiBankAccountSerivce {
	
	private String host = "https://uibank-api.azurewebsites.net/api/";
	private Response response;
	
	public void createAccount(String token, String payload) {
		response = RestAssured.given()
				   .header("Authorization", "Bearer "+token) 
		           .header("Content-Type", "application/json")
		           .when()
		           .body(payload)
		           .post(host+"accounts");
	}
	
	public void validateResponseStatusCode(int statuCode) {
		response.then()
		        .log().all()
		        .assertThat()
		        .statusCode(statuCode);
	}

}
