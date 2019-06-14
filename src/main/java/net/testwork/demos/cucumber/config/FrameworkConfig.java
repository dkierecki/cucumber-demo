package net.testwork.demos.cucumber.config;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("net.testwork.demos.cucumber")
@PropertySource("classpath:environment/${spring.profiles.active:local}.properties")
public class FrameworkConfig {

    public static int ONE_MINUTE = 60000;

    @Autowired
    public FrameworkConfig(Environment env) {
        com.codeborne.selenide.Configuration.baseUrl = env.getProperty("wikipedia.url");
        com.codeborne.selenide.Configuration.browser = env.getProperty("browser");
        com.codeborne.selenide.Configuration.timeout = ONE_MINUTE;
        com.codeborne.selenide.Configuration.startMaximized = true;
        com.codeborne.selenide.Configuration.savePageSource = false;
        com.codeborne.selenide.Configuration.screenshots = false;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

        WebDriverManager.chromedriver().version(env.getProperty("browser.version"));
    }
}
