package com.it_academy.catalogOnlinerTests.local;

import com.it_academy.catalogOnlinerTests.pageobject.CatalogPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalTestTwo extends LocalBaseTest {

    @Test
    public void checkElementsFromCatalogAsideList() {
        LOG.info("local test2 info");
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.clickOnCatalogNavigationClassifierLink("Компьютеры");
        catalogPage.navigateToCatalogElements(" Комплектующие ");
        assertThat(catalogPage.getElementsFromCatalogAsideList())
                .as("Elements don't match")
                /*.containsExactly("Ноутбуки, компьютеры, мониторы",
                        "Комплектующие", "Техника для печати и дизайна", "Манипуляторы и устройства ввода",
                        "Хранение данных", "Мультимедиа периферия", "Сетевое оборудование",
                        "Аксессуары к ноутбукам и компьютерам", "Электропитание",
                        );*/
                .hasSize(10);
    }
}
