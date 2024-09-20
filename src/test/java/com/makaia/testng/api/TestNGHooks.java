package com.makaia.testng.api;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.makaia.selenium.api.base.SeleniumBase;

public class TestNGHooks extends SeleniumBase {
	
	protected static String incidentNumber;
	
	@BeforeMethod
	public void beforeMethod() {
		browserLaunch("chrome");
	}
	
	@AfterMethod
	public void afterMethod() {
		quit();
	}

}