package com.test.helpers;

import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.test.models.LoginResponsePOJO;
import com.test.models.UpdateUserPOJO;
import com.test.models.UserPOJO;
import com.test.constants.Endpoints;
import com.test.models.AddUserPOJO;
import com.test.models.LoginObjectPOJO;
import com.test.utils.Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UserServiceHelper {
public static String getBaseUri() {
	Utils CU=new Utils();
	Properties configPropertiesFile=CU.loadFile("config");
	String baseURI=CU.getConfigProperty("baseurl1",configPropertiesFile);
	System.out.println(baseURI);
	return baseURI;
	
}
public static Response LoginToApplication() {
	Utils CU=new Utils();
	Properties configPropertiesFile=CU.loadFile("config");
	String username=CU.getConfigProperty("username",configPropertiesFile);
	String password=CU.getConfigProperty("password",configPropertiesFile);
	LoginObjectPOJO ob =new LoginObjectPOJO(username,password);
	Response response=RestAssured.
			given().
			contentType("application/json").
			body(ob).
			when().
			post(Endpoints.LOGIN);
	       
	        com.test.models.LoginResponsePOJO[]	list=response.as(com.test.models.LoginResponsePOJO[].class);
	        String token1=list[0].getToken();
	        System.out.println("token1========="+token1);
	        return response;
}
public static String getToken() {
	Response response=LoginToApplication();
	String token=response.jsonPath().get("[0].token");
	System.out.println("token"+token);
	return token;
}
public static void  getUserData() {
	/*String token=getToken();
	Header header=new Header("token",token);
	System.out.println("user token:"+token);
	Response response=LoginToApplication();
	response=RestAssured.given().header(header)
			.when()
			.get(Endpoints.GET_DATA);
	UserPOJO[]userarray=response.as(UserPOJO[].class);
	List<UserPOJO>list=Arrays.asList(userarray);
	response.then().statusCode(200);
	System.out.println("num of employee entries ="+response.jsonPath().get("$.size()"));
return list; */
	 RestAssured.baseURI=getBaseUri();
	 RequestSpecification req= RestAssured.given();
	//System.out.println("List of employees"+listOfUsers.size());
	  Response res =req.when().get("https://reqres.in/api/users?page=2"); 
	  System.out.println("num of employee entries ="+res.jsonPath().get("data.size()"));
	  System.out.println("completed");
}
public static void  getUserDataPrint() {
	RequestSpecification req= RestAssured.given();
	//System.out.println("List of employees"+listOfUsers.size());
	  Response res =req.when().get("https://reqres.in/api/users?page=2"); 
	  res.prettyPrint();
	System.out.println("completed");
}
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
public static Response updateUserData(Response res) {
	String token=getToken();
	Header header=new Header("token",token);
	System.out.println("user token:"+token);
	Response response=LoginToApplication();
	response=RestAssured.given().header(header)
			.when()
			.put(Endpoints.UPDATE_DATA);
	UpdateUserPOJO updateuser=response.as(UpdateUserPOJO.class);
	System.out.println(updateuser);
	response.then().statusCode(200);
	System.out.println("num of employee entries ="+response.jsonPath().get("$.size()"));
	response.then().body(updateuser.getDepno("7"), equalTo(20));
	response.then().body("$.depno",equalTo(20));
	return res;	
}
public static Response deleteUserData(Response res) {
	String token=getToken();
	Header header=new Header("token",token);
	System.out.println("user token:"+token);
	Response response=LoginToApplication();
	response=RestAssured.given().header(header)
			.when()
			.delete(Endpoints.DELETE_DATA);
	response.then().statusCode(200);
	System.out.println("num of employee entries ="+response.jsonPath().get("$.size()"));
	response.then().body("$.depno",equalTo(19));
	return res;
}
}

