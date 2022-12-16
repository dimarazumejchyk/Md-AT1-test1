package com.it_academy.catalogOnlinerTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.it_academy.catalogOnlinerTests.local.LocalBaseTest;
import com.it_academy.catalogOnlinerTests.pageobject.CatalogPage;
import com.it_academy.catalogOnlinerTests.pageobject.HomePage;
import com.it_academy.listeners.AllureListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Listeners(AllureListener.class)
public class MainTest {
    private final static String ONLINER_URL = "https://www.onliner.by/";

    protected static final Logger LOGGER = LoggerFactory.getLogger(LocalBaseTest.class);

    @BeforeMethod
    public void webDriverInit() {
        System.out.println("================================================================@BeforeMethod");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
        LOGGER.info("BeforeClass webDriverInit");
        WebDriverManager.chromedriver().setup();
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
        HomePage homePage = new HomePage();
        homePage.openOnliner(ONLINER_URL);
        homePage.clickOnHeaderElement("Каталог");
    }

    @Test
    public void checkElementsFromCatalogClassifier() {
        System.out.println("================================================================test1");
        LOGGER.info("checkElementsFromCatalogClassifier test1 info");
        CatalogPage catalogPage = new CatalogPage();
        assertThat(catalogPage.getElementsFromCatalogClassifier())
                .as("Elements don't match")
                .containsExactly("Onlíner Prime", "Электроника", "Компьютеры и сети", "Бытовая техника",
                        "Стройка и ремонт", "Дом и сад", "Авто и мото", "Красота и спорт", "Детям и мамам",
                        "Работа и офис");
    }

    @Test
    public void checkElementsFromCatalogAsideList() {
        System.out.println("================================================================test2");

        LOGGER.info("checkElementsFromCatalogAsideList test2 info");
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
                .hasSize(12);
    }

    @Test
    public void checkElementsAndPriceQuantityFromCatalogDropdownList() {
        System.out.println("================================================================test3");

        LOGGER.info("checkElementsAndPriceQuantityFromCatalogDropdownList test3 info");
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


    @AfterClass
    public void webDriverClose() {
        System.out.println("================================================================@AfterClass");
        LOGGER.info("AfterClass LocalBaseTest");
    }
}
//clean test -DsuiteXmlFile=local-parallel-suite-1.xml