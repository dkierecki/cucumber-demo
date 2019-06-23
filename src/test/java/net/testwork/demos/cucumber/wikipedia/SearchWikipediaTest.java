package net.testwork.demos.cucumber.wikipedia;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

// AllureCucumber3Jvm plugin is responsible for generating proper test execution report out of cucumber scenarios 
// allure.results.directory parameter defined in allure.properties files define location where results will be located
// using  Maven allure:serve plugin or executing allure serve command will generate test execution report

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/wikipedia/SearchWikipedia.feature"},
        glue = {"net.testwork.demos.cucumber.steps"},
        plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm"})
public class SearchWikipediaTest {
}
