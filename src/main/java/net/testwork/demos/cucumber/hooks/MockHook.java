package net.testwork.demos.cucumber.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.restassured.RestAssured;
import lombok.extern.slf4j.Slf4j;
import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;

import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@Slf4j
public class MockHook {

    private static final int MOCK_SERVER_PORT = 1080;
    private static final String MOCK_SERVER_HOST = "localhost";
    private ClientAndServer mockServer;

    @Before("@UseMockServer")
    public void beforeScenario() {
        log.info("Starting MockServer");
        mockServer = startClientAndServer(MOCK_SERVER_PORT);
        new MockServerClient(MOCK_SERVER_HOST, MOCK_SERVER_PORT)
                .when(
                        request()
                                .withMethod("GET")
                                .withPath("/api/planets")
                )
                .respond(
                        response()
                                .withStatusCode(200)
                                .withBody("{\"results\": [{\"name\":\"Mock IX\"}]}")
                );
        RestAssured.proxy(MOCK_SERVER_HOST, MOCK_SERVER_PORT);
    }

    @After("@UseMockServer")
    public void afterScenario() {
        log.info("Stopping MockServer");
        mockServer.stop();
        RestAssured.proxy = null;
    }
}
