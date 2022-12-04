package com.it_academy.catalogOnlinerTests.pageobject;

import com.codeborne.selenide.Selenide;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class HomePage {
    private static final String HEADER_ELEMENT_LINK_XPATH_PATTERN =
            "//span[@class='b-main-navigation__text' and contains(text(), '%s')]";

    public HomePage  clickOnHeaderElement(String link) {
       $x(format(HEADER_ELEMENT_LINK_XPATH_PATTERN, link))
               .shouldBe(visible, ofSeconds(10))
               .click();
       return this;
    }

    public HomePage openOnliner(String url){
        Selenide.open(url);
        return this;
    }
}
