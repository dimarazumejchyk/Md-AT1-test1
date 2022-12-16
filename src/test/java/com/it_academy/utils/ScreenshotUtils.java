package com.it_academy.utils;

import com.codeborne.selenide.Screenshots;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class ScreenshotUtils {
    protected static final Logger LOGGER = LoggerFactory.getLogger(ScreenshotUtils.class);

    private ScreenshotUtils() {
    }
    public static void takeScreenshotAndAttachToAllureReport() {
        try {
            File screenshotAs = Screenshots.takeScreenShotAsFile();
            Allure.addAttachment("Screenshot: " + LocalDateTime.now(), FileUtils.openInputStream(screenshotAs));
        } catch (IOException e) {
            LOGGER.error("Error creating screenshot");
        }
    }
}
