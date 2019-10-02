package net.testwork.demos.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.testwork.demos.cucumber.db.StarWarsDatabaseContainer;
import net.testwork.demos.cucumber.pages.WikipediaContentPage;
import net.testwork.demos.cucumber.pages.WikipediaMainPage;
import net.testwork.demos.cucumber.rest.PlanetsRestService;
import org.assertj.core.api.SoftAssertions;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

// Private variables (List<String> planets, private SoftAssertions softly;) can be shared between steps within single scenario

@Slf4j
public class StarWarsSteps {

    private static final String PEOPLE_QUERY = "SELECT name FROM characters";
    @Autowired
    private PlanetsRestService planetsRestService;

    @Autowired
    private WikipediaMainPage wikiMainPage;

    @Autowired
    private WikipediaContentPage contentPage;

    private List<String> planets;
    private List<String> characters = new ArrayList<>();
    private SoftAssertions softly;

    @Given("^list of all SW planets is obtained$")
    public void getAllPlanets() {
        log.info("Getting all planets");
        planets = planetsRestService.getPlanets();
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

    @Given("^list of Star Wars characters is obtained$")
    public void getCharacters() throws SQLException {
        ResultSet resultSet = StarWarsDatabaseContainer.getInstance().performQuery(PEOPLE_QUERY);

        while (resultSet.next()) {
            characters.add(resultSet.getString(1));
        }
    }

    @When("^user searches for people in Wikipedia$")
    public void searchCharacters() {
        softly = new SoftAssertions();
        characters.forEach(character -> {
            wikiMainPage.searchInput().setValue(character).pressEnter();
            softly.assertThat(contentPage.heading().text()).isEqualToIgnoringCase(character);
        });
    }

    @Then("^user should see content page for every character$")
    public void showCharacters() {
        softly.assertAll();
    }
    
    @Then(("^planet list should contain following values$"))
    public void shouldSeePlanetList(List<String> expectedPlanets) {
        assertThat(planets).containsExactlyInAnyOrderElementsOf(expectedPlanets);
    }
}
