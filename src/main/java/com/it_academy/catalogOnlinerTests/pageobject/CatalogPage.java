package com.it_academy.catalogOnlinerTests.pageobject;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static java.lang.String.format;
import static java.time.Duration.ofSeconds;

public class CatalogPage {
    private static final String CATALOG_ELEMENT_XPATH_PATTERN = "//ul[@class='catalog-navigation-classifier ']//span[contains(text(), '%s')]";
    private static final String ELEMENT_FROM_CATALOG_ASIDE_LIST_XPATH_PATTERN = "//div[@class='catalog-navigation-list__aside-title' and text()= '%s']";

    public CatalogPage navigateToCatalogElements(String asideElement) {
        $x(format(ELEMENT_FROM_CATALOG_ASIDE_LIST_XPATH_PATTERN, asideElement))
                .shouldBe(visible, ofSeconds(10)).hover();
        return this;
    }

    public CatalogPage clickOnCatalogNavigationClassifierLink(String catalogElement) {
        $x(format(CATALOG_ELEMENT_XPATH_PATTERN, catalogElement))
                .shouldBe(visible, ofSeconds(10)).click();
        return this;
    }

    public List<String> getElementsFromCatalogClassifier() {
        return $$x("//ul[@class='catalog-navigation-classifier ']"
                + "//li[@class='catalog-navigation-classifier__item ']")
                .shouldBe(sizeGreaterThan(0), ofSeconds(10)).texts();
    }

    public List<String> getElementsFromCatalogAsideList() {
         return $$x("//div[@class='catalog-navigation-list__aside catalog-navigation-list__aside_active']"
                 + "//div[@class='catalog-navigation-list__aside-title']")
                        .shouldHave(sizeGreaterThan(0), ofSeconds(10)).texts();
    }

    public List<String> getElementsFromCatalogDropdownList() {
               return  $$x("//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']" +
                       "//span[@class='catalog-navigation-list__dropdown-title']")
                        .shouldHave(sizeGreaterThan(0), ofSeconds(10)).texts();
    }

    public List<String> getPriceQuantityDropdownList() {
             return $$x("//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']"
                        + "//span[@class='catalog-navigation-list__dropdown-description']")
                        .shouldHave(sizeGreaterThan(0), ofSeconds(10)).texts();
    }

}
