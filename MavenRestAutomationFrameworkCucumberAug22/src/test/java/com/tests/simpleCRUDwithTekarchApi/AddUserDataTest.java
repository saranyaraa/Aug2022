package com.tests.simpleCRUDwithTekarchApi;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.testng.Assert;

import com.test.constants.Endpoints;
import com.test.helpers.ReusableMethods;
import com.test.models.AddUserPOJO;
import com.test.tests.TekArchApiTestScriptE2E;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddUserDataTest extends TekArchApiTestScriptE2E  {
	public static Response addUserData(Response res) {
		String token=getToken();
		Header header=new Header("token",token);
		System.out.println("user token:"+token);
		Response response=LoginToApplication();
		response=RestAssured.given().header(header)
				.when()
				.post(Endpoints.ADD_DATA);
		AddUserPOJO adduser=response.as(AddUserPOJO.class);
		System.out.println(adduser);
		response.then().statusCode(200);
		System.out.println("num of employee entries ="+response.jsonPath().get("$.size()"));
		response.then().body("$.size()",equalTo(7));	
	return res;	
	}
}
