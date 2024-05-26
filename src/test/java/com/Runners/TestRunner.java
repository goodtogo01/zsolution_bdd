package com.Runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="../Zsolution_BDD/src/main/java/com/Features/Student_E2E_Entry.feature",
		glue = {"com.StepDef"},
		plugin = {"pretty", "html: OutPut_Result"},
		dryRun = false,
		monochrome = false,
		strict = true
		
		)

public class TestRunner {

}
