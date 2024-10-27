package com.makaia.testng.api;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.makaia.servicenow.api.services.UiBankAccountSerivce;
import com.makaia.servicenow.api.services.UiBankLoginService;

public class UiBankTest {
	
	private String authToken;
    private String userId;
    UiBankLoginService loginSerivce = new UiBankLoginService();
    UiBankAccountSerivce accountService = new UiBankAccountSerivce();
	
	@BeforeMethod
	public void beforeMethod() {
		loginSerivce.createAuthToken();
		authToken = loginSerivce.extractToken();
		userId = loginSerivce.extractUserId();
	}
	
	@Test
	public void test() {
		System.out.println(authToken);
		System.out.println(userId);
		String payload = "{\r\n"
				+ "    \"friendlyName\": \"Test Challenge\",\r\n"
				+ "    \"type\": \"checking\",\r\n"
				+ "    \"userId\": \""+userId+"\",\r\n"
				+ "    \"balance\": 100,\r\n"
				+ "    \"accountNumber\": 43503704\r\n"
				+ "}";
		accountService.createAccount(authToken, payload);
		accountService.validateResponseStatusCode(200);
	}

}