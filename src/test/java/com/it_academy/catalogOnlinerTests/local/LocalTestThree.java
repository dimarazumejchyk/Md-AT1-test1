package com.it_academy.catalogOnlinerTests.local;

import com.it_academy.catalogOnlinerTests.pageobject.CatalogPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalTestThree extends LocalBaseTest {

    @Test
    public void checkElementsAndPriceQuantityFromCatalogDropdownList() {
        LOG.info("local test3 info");
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
                .isNotNull()
                .hasSize(14);
    }
}
