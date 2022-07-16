package com.vcentry.lab.step.Definition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.vcentry.lab.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {
	@Before
	public void beforeScenario() {
		System.out.println("------------Before Scenario-------------");
	}
	
	@After
	public void afterScenario() {
		System.out.println("-------------After Scenario-------------");
		getDriver().close();
	}
	@AfterStep
	public void addScreenshot(Scenario scenario){

		//validate if scenario has failed
		if(scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "image"); 
		}
		
	}
}
