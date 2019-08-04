package net.testwork.demos.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.testwork.demos.cucumber.pages.WikipediaContentPage;
import net.testwork.demos.cucumber.pages.WikipediaMainPage;
import net.testwork.demos.cucumber.rest.PlanetsRestService;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

// Private variables (List<String> planets, private SoftAssertions softly;) can be shared between steps within single scenario

@Slf4j
public class StarWarsSteps {

    @Autowired
    private PlanetsRestService planetsRestService;

    @Autowired
    private WikipediaMainPage wikiMainPage;

    @Autowired
    private WikipediaContentPage contentPage;

    private List<String> planets;
    private SoftAssertions softly;

    @Given("^list of all SW planets is obtained$")
    public void getAllPlanets() {
        log.info("Getting all planets");
        planets = planetsRestService.getPlanets();
    }

    @Given("^list of all SW people is obtained$")
    public void getAllPeople() {
        log.info("Getting all people");

    }
    
    @When("^user searches for planets in Wikipedia$")
    public void searchPlanets() {
        softly = new SoftAssertions();
        planets.forEach(planet -> {
            wikiMainPage.searchInput().setValue(planet).pressEnter();
            softly.assertThat(contentPage.heading().text()).isEqualToIgnoringCase(planet);
        });
    }
    
    @Then("^user should see content page for every planet$")
    public void showPlanets() {
        softly.assertAll();
    }
}
