package com.test.tests;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.helpers.ReusableMethods;
import com.test.helpers.UserServiceHelper;
import com.test.models.UserPOJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class TekArchApiTestScriptE2E extends UserServiceHelper {
	@BeforeMethod
public static void baseuri() {
	RestAssured.baseURI=getBaseUri();
}

public static void TC01_validlogin() {
		
	String token=getToken();
	System.out.println("Token:="+token);
}
@Test
public static void TC0102()throws IOException{
	RequestSpecification req= RestAssured.given();
	
	Response res=req.when().get(getBaseUri());
   // Response res =req.when().get("https://reqres.in/api/users?page=2/"); 
    res.prettyPrint();
    
  //  res.then().body("Response",equalTo("success"));
    System.out.println("num of employee entries ="+res.jsonPath().get("data.size()"));
    System.out.println("completed");
}
public static void TC03_getUserData()throws IOException {
	//returns list of users
	
	//List<UserPOJO>listOfUsers=getUserData();
	//System.out.println("first account number"+listOfUsers.get(0).getAccountnumber1("accno"));
}
public static void TC04_addUserData()throws IOException {
	//add a user data
	
RequestSpecification req= RestAssured.given();
	
	Response res=req.when().get(getBaseUri());
	 addUserData(res);
	ReusableMethods.verifyStatusCode(res,200);
	String status=ReusableMethods.getJsonPathData(res,"status");
	Assert.assertEquals(status, "success");	
}
public static void TC05_updateUserData()throws IOException {
	
//update depno;
RequestSpecification req= RestAssured.given();
	
	Response res=req.when().get(getBaseUri());
	 updateUserData(res);
	ReusableMethods.verifyStatusCode(res,200);
	String status=ReusableMethods.getJsonPathData(res,"status");
	Assert.assertEquals(status, "success");		
}

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