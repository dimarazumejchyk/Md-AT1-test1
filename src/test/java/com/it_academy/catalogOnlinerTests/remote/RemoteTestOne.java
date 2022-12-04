package com.it_academy.catalogOnlinerTests.remote;

import com.it_academy.catalogOnlinerTests.pageobject.CatalogPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Test
public class RemoteTestOne extends RemoteBaseTest {

    @Test
    public void test1() {
        LOG.info("remote test1 info");
        CatalogPage catalogPage = new CatalogPage();
        assertThat(catalogPage.getElementsFromCatalogClassifier())
                .as("Elements don't match")
                .containsExactly("Onlíner Prime", "Электроника", "Компьютеры и сети", "Бытовая техника",
                        "Стройка и ремонт", "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам",
                        "Работа и офис");
    }
}
