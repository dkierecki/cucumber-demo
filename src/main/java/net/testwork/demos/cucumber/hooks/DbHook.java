package net.testwork.demos.cucumber.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import lombok.extern.slf4j.Slf4j;
import org.testcontainers.containers.MySQLContainer;

@Slf4j
public class DbHook {

    private MySQLContainer mysql = new MySQLContainer();

    @Before("@UseDB")
    public void beforeScenario() {
        log.info("Starting MySQL");
        mysql.start();
    }

    @After("@UseDB")
    public void afterScenario() {
        log.info("Stopping MySQL");
        mysql.stop();
    }
}
