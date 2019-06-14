package net.testwork.demos.cucumber.pages;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class WikipediaMainPage {
    
    private static final String WIKI_LOGO = "img.central-featured-logo";
    
    public SelenideElement logo(){
        return $(WIKI_LOGO);
    }
}
