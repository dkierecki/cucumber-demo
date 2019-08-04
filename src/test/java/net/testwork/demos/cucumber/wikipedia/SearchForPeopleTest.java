package net.testwork.demos.cucumber.wikipedia;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/wikipedia/SearchForPeople.feature"},
        glue = {"net.testwork.demos.cucumber.steps", "net.testwork.demos.cucumber.hooks"},
        plugin = {"io.qameta.allure.cucumber3jvm.AllureCucumber3Jvm"})
public class SearchForPeopleTest {
}
