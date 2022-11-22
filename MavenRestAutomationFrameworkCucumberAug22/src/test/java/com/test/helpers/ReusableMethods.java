package com.test.helpers;

import java.util.Timer;
import java.util.concurrent.TimeUnit;

import com.test.models.AddUserPOJO;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class ReusableMethods {
	public static AddUserPOJO user;
	public static AddUserPOJO getUserDatatoAdd() {
	user=new AddUserPOJO();
	user.setAccountno("Accno1");
	user.setDepno("5");
	user.setSalary("6000");
	user.setPincode("45678");
	return user;
	}
	public static void verifyStatusCode(Response response,int code) {
		response.then().statusCode(code);
		
	}
public String getContentType(Response response) {
	return response.getContentType();
}

	public static String getJsonPathData(Response response, String string) {
		return string;	
	}
	public long getResponseTimein(Response response, TimeUnit unit) {
	return response.getTimeIn(unit);	
	}
	}
