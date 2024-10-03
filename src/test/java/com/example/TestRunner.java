package com.example;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}