package net.testwork.demos.cucumber.rest;

import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;

@Service
@Slf4j
public class PlanetsRestService {


    public List<String> getPlanets() {
        RestAssured.useRelaxedHTTPSValidation();
        return RestAssured
                .given()
                .baseUri("https://swapi.co/api")
                .basePath("planets")
                .when()
                .get()
                .then()
                .statusCode(SC_OK)
                .extract()
                .body().jsonPath().getList("results.name");
    }

}