package com.it_academy.catalogOnlinerTests.local;

import com.it_academy.catalogOnlinerTests.pageobject.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static com.it_academy.catalogOnlinerTests.driverManager.WebDriverLocal.setDriver;


public class LocalBaseTest {
    private final static String ONLINER_URL = "https://www.onliner.by/";

    protected static final Logger LOG = LoggerFactory.getLogger(LocalBaseTest.class);

    @BeforeClass
    @Parameters(value = {"browser"})
    public void webDriverInit(String browser) {
        LOG.info("BeforeClass LocalBaseTest");
        setDriver(browser);
        HomePage homePage = new HomePage();
        homePage.openOnliner(ONLINER_URL);
        homePage.clickOnHeaderElement("Каталог");
    }

    @AfterClass
    public void webDriverClose() {
        LOG.info("AfterClass LocalBaseTest");
    }

}
