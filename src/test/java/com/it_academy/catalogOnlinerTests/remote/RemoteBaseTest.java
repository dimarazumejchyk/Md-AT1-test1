package com.it_academy.catalogOnlinerTests.remote;

import com.it_academy.catalogOnlinerTests.pageobject.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import static com.it_academy.catalogOnlinerTests.driverManager.WebDriverRemote.setDriver;

public class RemoteBaseTest {

    private final static String ONLINER_URL = "https://www.onliner.by/";
    protected static final Logger LOG = LoggerFactory.getLogger(RemoteBaseTest.class);

    @BeforeClass
    @Parameters(value = {"browser"})
    public void webDriverInit(String browser) {
        LOG.info("BeforeClass RemoteBaseTest");
        setDriver(browser);
        HomePage homePage = new HomePage();
        homePage.openOnliner(ONLINER_URL);
        homePage.clickOnHeaderElement("Каталог");
    }

    @AfterClass
    public void webDriverClose() {
        LOG.info("AfterClass RemoteBaseTest");
    }

}
