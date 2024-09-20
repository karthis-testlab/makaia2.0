package com.makaia.servicenow.ui.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.makaia.general.utils.PropertiesHandler.config;
import com.makaia.servicenow.ui.pages.LoginPage;
import com.makaia.testng.api.TestNGHooks;

public class IncidentTests extends TestNGHooks {
	
	@BeforeTest
	public void beforeTest() {
		testcaseName = "CreateIncident";
		testDescription = "Validation of create incident";
		authors = "Karthikeyan";
		category = "Smoke";
	}
	
	@Test
	public void testCreateNewIncident() {
		new LoginPage()
		    .enterUserName(config("makaia.servicenow.username"))
		    .enterPassword("vW0eDfd+A0V-")
		    .clickLoingButton()
		    .getIncidentNumber()
		    .enterCallerId("Service Desk")
		    .enterShortDescription("Sub")
		    .clickSubmitButton()
		    .filterByNumber()
		    .validateIncidentCreation();
		
	}
	

}