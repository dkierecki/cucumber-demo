package net.testwork.demos.cucumber.wikipedia;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

// JUnit test is central point for running executable test specification 
// @CucumberOptions annotation provides information where to find test specification (features parameter) and how to interpret it (glue parameter)

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/wikipedia/OpenWikipedia.feature"},
        glue = {"net.testwork.demos.cucumber.steps"},
        plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm"})
public class OpenWikipediaTest {
}
