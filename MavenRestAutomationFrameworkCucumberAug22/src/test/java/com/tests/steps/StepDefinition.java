package com.tests.steps;

import com.test.constants.Endpoints;
import com.test.helpers.UserServiceHelper;
import com.test.models.LoginObjectPOJO;
import com.test.models.UserPOJO;
import com.test.utils.Utils;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinition extends UserServiceHelper  {
	
	@Given("the endpoint is up")
	public void the_endpoint_is_up() {
	   RestAssured.baseURI=getBaseUri();
	    
	}

	@When("i send get request with the endpoint as {string}")
	public void i_send_get_request_with_the_endpoint(String string) {
		
		  RestAssured.baseURI=getBaseUri();
		
	}

	@Then("i should get the list of userdata in the response")
	public void i_should_get_the_list_of_userdata_in_the_response() {
		
		  getUserData();
	}

	@Then("print the number of user data exists to the console")
	public void print_the_number_of_user_data_exists_to_the_console() {
		
		getUserDataPrint();
	}
}
