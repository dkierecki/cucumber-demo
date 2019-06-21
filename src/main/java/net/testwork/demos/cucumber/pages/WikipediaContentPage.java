package net.testwork.demos.cucumber.pages;

import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;

@Component
public class WikipediaContentPage {
    
    private static final String HEADING = "#firstHeading";
    
    public SelenideElement heading(){
        return $(HEADING);
    }   
    
}
