package net.testwork.demos.cucumber.config;

import com.codeborne.selenide.WebDriverProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

//In order to use this custom WebDriver config provide ths class name in Selenide configuration
// e.g. com.codeborne.selenide.Configuration.browser = net.testwork.demos.cucumber.config.CustomChromeDriver

public class CustomChromeDriver implements WebDriverProvider {

    private static Map<String, Object> deviceMetrics = new HashMap<String, Object>() {
        {
            put("width", 800);
            put("height", 600);
            put("pixelRatio", 1.0);
        }
    };

    private static Map<String, Object> mobileEmulation = new HashMap<String, Object>() {
        {
            put("deviceMetrics", deviceMetrics);
        }
    };

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {
        WebDriverManager.chromedriver().version("2.46").setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        chromeOptions.merge(desiredCapabilities);

        return new ChromeDriver(chromeOptions);
    }

}
