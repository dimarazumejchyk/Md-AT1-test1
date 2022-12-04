package com.it_academy.catalogOnlinerTests.remote;

import com.it_academy.catalogOnlinerTests.pageobject.CatalogPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoteTestThree extends RemoteBaseTest {

    @Test
    public void test3() {
        LOG.info("remote test3 info");
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.clickOnCatalogNavigationClassifierLink("Компьютеры");
        catalogPage.navigateToCatalogElements(" Комплектующие ");
        assertThat(catalogPage.getElementsFromCatalogDropdownList())
                .as("Elements don't match")
                .containsExactly("Видеокарты", "Процессоры", "Материнские платы", "Оперативная память",
                        "Системы охлаждения", "SSD", "Жесткие диски", "Корпуса", "Блоки питания", "Звуковые карты",
                        "Сетевые адаптеры", "Оптические приводы", "ТВ-тюнеры и карты видеозахвата",
                        "Аксессуары для майнинга");
        assertThat(catalogPage.getPriceQuantityDropdownList())
                .as("Elements do not contain quantity or price")
                .isNotEmpty()
                .isNotNull();
    }
}
