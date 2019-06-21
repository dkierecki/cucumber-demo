package net.testwork.demos.cucumber.wikipedia;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/wikipedia/SearchWikipedia.feature"},
        glue = {"net.testwork.demos.cucumber.steps"},
        plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm"})
public class SearchWikipediaTest {
}
