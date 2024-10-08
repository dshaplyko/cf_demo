package com.example;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example.steps"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}