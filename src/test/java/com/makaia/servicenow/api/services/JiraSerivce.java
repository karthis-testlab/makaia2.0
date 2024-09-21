package com.makaia.servicenow.api.services;

import java.io.File;

import org.hamcrest.Matchers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JiraSerivce {
	
	private String issueId;
	
	public JiraSerivce createIssue() {
		String url = "https://karthikeselene.atlassian.net/rest/api/3/issue";
		String payload = """
				{
                     "fields": {
                                "summary": "New Issue from REST API AUG Session",
                                "issuetype": {
                                           "id": "10012"
                                           },
                                  "project": {
                                            "id": "10003"
                                            }
                   }
                  }
				""";
		issueId = RestAssured.given()
		           .auth()
		           .preemptive()
		           .basic("karthike.selene@gmail.com", "ATATT3xFfGF0eenMiSNCmo6rgh24ht-bMCqJ_0rp6dqv-G0vmpllmyFc05PQZDnDJ0MwkNW4UA7tmcRjO9DaKjoKCilZfh2-AHlyCg9-HJr5N8a9il08xkl1uKit4kAkU1lWMhxjRaoUZ7d_ejigUcvqtELDWL7CehN4mbfJT7tQ1CtLSRMNwYQ=EE0D6494")
	               .header("Content-Type", "application/json")
	               .when()
	               .body(payload)
	               .post(url)
	               .then()
	               .assertThat()
	               .statusCode(201)
	               .extract()
	               .jsonPath()
	               .getString("id");
		return this;	               
	}
	
	public JiraSerivce attachement(String filePath) {
		String url = "https://karthikeselene.atlassian.net/rest/api/3";
		RestAssured.given()
		           .auth()
		           .preemptive()
		           .basic("karthike.selene@gmail.com", "ATATT3xFfGF0eenMiSNCmo6rgh24ht-bMCqJ_0rp6dqv-G0vmpllmyFc05PQZDnDJ0MwkNW4UA7tmcRjO9DaKjoKCilZfh2-AHlyCg9-HJr5N8a9il08xkl1uKit4kAkU1lWMhxjRaoUZ7d_ejigUcvqtELDWL7CehN4mbfJT7tQ1CtLSRMNwYQ=EE0D6494")
		           .header("X-Atlassian-Token", "no-check")
		           .pathParam("issueIdOrKey", issueId)
		           .log()
		           .all()
		           .when()		           
		           .multiPart(new File(filePath))
		           .post(url+"/issue/{issueIdOrKey}/attachments")
		           .then()
		           .log()
		           .all()
		           .assertThat()
		           .statusCode(200)
		           .statusLine(Matchers.containsString("OK"))
		           .contentType(ContentType.JSON);
		return this;
	}

}
