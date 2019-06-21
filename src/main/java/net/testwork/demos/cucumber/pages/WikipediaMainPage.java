package net.testwork.demos.cucumber.pages;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class WikipediaMainPage {
    
    private static final String WIKI_LOGO = "img.central-featured-logo";
    private static final String SEARCH_INPUT = "input#searchInput";
    
    public SelenideElement logo(){
        return $(WIKI_LOGO);
    }   
    
    public SelenideElement searchInput(){
        return $(SEARCH_INPUT);
    }
}
