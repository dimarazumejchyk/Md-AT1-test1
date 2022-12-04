package com.it_academy.catalogOnlinerTests.driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.it_academy.catalogOnlinerTests.driverManager.OptionsManager.getChromeDesiredCapabilities;
import static com.it_academy.catalogOnlinerTests.driverManager.OptionsManager.getEdgeDesiredCapabilities;
import static com.it_academy.catalogOnlinerTests.driverManager.OptionsManager.getFirefoxDesiredCapabilities;

public class CapabilityFactory {
    public DesiredCapabilities capabilities;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public DesiredCapabilities getCapabilities(String browser) {
        switch (browser) {
            case "chrome":
                capabilities = getChromeDesiredCapabilities();
                break;
            case "edge":
                capabilities = getEdgeDesiredCapabilities();
                break;
            case "firefox":
                capabilities = getFirefoxDesiredCapabilities();
                break;
        }
        return capabilities;
    }
}
