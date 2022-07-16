package com.vcentry.lab.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)// junit main method//
@CucumberOptions(
		features = "C:src\\test\\resources\\features"   //feature file location
		,glue = {"com.vcentry.lab.step.Definition"}
		,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		,monochrome = true  //readable console
		,tags="@sanity"
		
		)
public class TestRunner {
//test
}
