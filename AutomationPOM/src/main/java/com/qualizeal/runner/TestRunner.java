package com.qualizeal.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/main/java/AddProduct.feature",
    glue = "com.qualizeal.stepDefinition",
    plugin = {
        "pretty",
        "html:target/cucumber-reports.html",
        "json:target/cucumber-reports.json"  
    },
    monochrome = true
)
public class TestRunner{

}
