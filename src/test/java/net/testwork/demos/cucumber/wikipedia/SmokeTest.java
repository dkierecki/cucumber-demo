package net.testwork.demos.cucumber.wikipedia;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

// @CucumberOptions tags parameter provides convenient way to execute only selected test

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/wikipedia"},
        glue = {"net.testwork.demos.cucumber.steps"},
        tags = {"@smoke"},
        plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm"})
public class SmokeTest {
}
