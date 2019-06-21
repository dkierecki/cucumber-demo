package net.testwork.demos.cucumber.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.springframework.stereotype.Component;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Component
public class WikipediaContentPage {

    private static final String HEADING = "#firstHeading";

    public SelenideElement heading() {
        return $(HEADING);
    }

    public ElementsCollection infoBoxRows() {
        return $$("table.infobox tr");
    }
}
