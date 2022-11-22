package com.tests.simpleCRUDwithTekarchApi;

import com.test.tests.TekArchApiTestScriptE2E;

public class LoginToApi extends TekArchApiTestScriptE2E {
	public static void TC01_validlogin() {
		
		String token=getToken();
		System.out.println("Token:="+token);
	}
}
