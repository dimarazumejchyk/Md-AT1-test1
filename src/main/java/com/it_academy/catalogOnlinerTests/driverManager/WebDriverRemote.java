package com.it_academy.catalogOnlinerTests.driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverRemote {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static CapabilityFactory capabilityFactory = new CapabilityFactory();

    public static void setDriver(String browser) {
        try {
            driver.set(new RemoteWebDriver(new URL("http://192.168.1.105:4444/"),
                    capabilityFactory.getCapabilities(browser)));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
