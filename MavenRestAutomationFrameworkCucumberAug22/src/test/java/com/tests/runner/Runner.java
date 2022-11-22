package com.tests.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features={"src/test/resources/simpleRestFeature.feature"},
		glue={"com.steps"}
		
		)
public class Runner extends AbstractTestNGCucumberTests  {

}
