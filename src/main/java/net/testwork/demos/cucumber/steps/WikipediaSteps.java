package net.testwork.demos.cucumber.steps;

import com.codeborne.selenide.Selenide;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.testwork.demos.cucumber.pages.WikipediaMainPage;
import org.springframework.beans.factory.annotation.Autowired;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

@Slf4j
public class WikipediaSteps {

    @Autowired
    private WikipediaMainPage wikiMainPage;

    @When("^Wikipedia page is opened$")
    public void openWiki() {
        open("/");
    }
    
    @Then("^user should see Wikipedia logo$")
    public void shouldSeeWikiLogo() {
        wikiMainPage.logo().shouldBe(visible);
    }
}
