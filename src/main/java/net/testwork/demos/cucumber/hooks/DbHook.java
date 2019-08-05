package net.testwork.demos.cucumber.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import lombok.extern.slf4j.Slf4j;
import net.testwork.demos.cucumber.db.StarWarsDatabaseContainer;
import org.testcontainers.containers.MySQLContainer;

@Slf4j
public class DbHook {

    private MySQLContainer mysql = StarWarsDatabaseContainer.getInstance();

    @Before("@UseDB")
    public void beforeScenario() {
        mysql.start();
    }

    @After("@UseDB")
    public void afterScenario() {
        mysql.stop();
    }
}
