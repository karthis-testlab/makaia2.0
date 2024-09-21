package com.makaia.servicenow.ui.tests;

import static com.makaia.general.utils.PropertiesHandler.config;
import static com.makaia.general.utils.PropertiesHandler.secret;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.makaia.servicenow.ui.pages.LoginPage;
import com.makaia.testng.api.TestNGHooks;

public class TC001_IncidentTests extends TestNGHooks {
	
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
		    .enterPassword(secret("service.now.instance.password"))
		    .clickLoingButton()
		    .getIncidentNumber()
		    .enterCallerId("Service Desk")
		    .enterShortDescription("Sub")
		    .clickSubmitButton()
		    .filterByNumber()
		    .validateIncidentCreation();
		
	}

}