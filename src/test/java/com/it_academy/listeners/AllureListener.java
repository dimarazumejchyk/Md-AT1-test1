package com.it_academy.listeners;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import static com.it_academy.utils.ScreenshotUtils.takeScreenshotAndAttachToAllureReport;

public class AllureListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult tr) {
        takeScreenshotAndAttachToAllureReport();
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        takeScreenshotAndAttachToAllureReport();
    }
}
