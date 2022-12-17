package com.it_academy.catalogOnlinerTests;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.it_academy.listeners.AllureListener;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(AllureListener.class)
public class ExampleTest {

    @BeforeClass
    public void beforeMethod() {
        System.out.println("=================== beforeExampleTest =====================");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test
    public void testOne() {
        try {
            System.out.println("=================== ExampleTest 1 ===================");
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTwo() {
        try {
            System.out.println("=================== ExampleTest 2 ===================");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
