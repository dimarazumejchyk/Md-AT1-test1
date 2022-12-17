package com.it_academy.catalogOnlinerTests.driverManager;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverLocal {
    //private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(String browser) {
        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                Configuration.startMaximized = true;
                Configuration.browser = "chrome";
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                Configuration.startMaximized = true;
                Configuration.browser = "edge";
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                Configuration.startMaximized = true;
                Configuration.browser = "firefox";
                break;
        }
    }
}
