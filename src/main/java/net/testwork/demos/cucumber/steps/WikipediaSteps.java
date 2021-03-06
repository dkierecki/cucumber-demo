package net.testwork.demos.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.testwork.demos.cucumber.pages.WikipediaContentPage;
import net.testwork.demos.cucumber.pages.WikipediaMainPage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static net.testwork.demos.cucumber.config.AllureReport.attachScreenshot;

@Slf4j
public class WikipediaSteps {

    @Autowired
    private WikipediaMainPage wikiMainPage;

    @Autowired
    private WikipediaContentPage contentPage;

    @Given("^Wikipedia page is opened$")
    @When("^user opens Wikipedia page$")
    public void openWiki() {
        open("/");
        attachScreenshot("open-wikipedia");

    }

    @When("^user search for '(.*)' phrase$")
    public void searchWiki(String searchPhrase) {
        wikiMainPage.searchInput().setValue(searchPhrase).pressEnter();
    }

    @Then("^user should see Wikipedia logo$")
    public void shouldSeeWikiLogo() {
        wikiMainPage.logo().shouldBe(visible);
    }

    @Then("^user should see content page for '(.*)' phrase$")
    public void shouldSeeContentPage(String searchPhrase) {
        contentPage.heading().shouldHave(text(searchPhrase));
    }

    @Then("^user should see '(.*)' character information$")
    public void showCharacterInformation(String characterName, Map<String, String> expectedCharacterInfo) {
        contentPage.heading().shouldHave(text(characterName));
        expectedCharacterInfo.forEach((key, value) -> {
            contentPage.infoBoxRows()
                    .findBy(text(key))
                    .find(By.cssSelector("td"))
                    .shouldHave(text(value));
        });

    }
}
