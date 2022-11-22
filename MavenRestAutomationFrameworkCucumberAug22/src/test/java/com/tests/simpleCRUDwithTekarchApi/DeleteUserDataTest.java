package com.tests.simpleCRUDwithTekarchApi;

import java.io.IOException;

import org.testng.Assert;

import com.test.helpers.ReusableMethods;
import com.test.helpers.UserServiceHelper;
import com.test.tests.TekArchApiTestScriptE2E;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteUserDataTest extends TekArchApiTestScriptE2E {
	
	public static void TC06_deleteUserData()throws IOException {
		//delete userdata;
		RequestSpecification req= RestAssured.given();
			
			Response res=req.when().get(getBaseUri());
			 deleteUserData(res);
			ReusableMethods.verifyStatusCode(res,200);
			String status=ReusableMethods.getJsonPathData(res,"status");
			Assert.assertEquals(status, "success");		
		}
}