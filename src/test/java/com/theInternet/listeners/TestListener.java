package com.theInternet.listeners;

import com.theInternet.testFactory.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends BaseTest implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        BaseTest baseTest = (BaseTest) result.getInstance();
        baseTest.takeScreenshot(result.getName());
        if (test != null) {
            test.fail("Test failed and screenshot taken : " + result.getName());
            test.fail(result.getThrowable());
        }
    }
    // Implement other methods as needed



    @Override
    public void onTestStart(ITestResult result) {
        this.test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed: " + result.getName());
    }
/*
    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test failed: " + result.getName());
        test.fail(result.getThrowable());
        // Take screenshot
        takeScreenshot(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        // This can be used for any final reporting steps if needed
       // extent.flush(); // Ensure report is flushed
    }



     */
}

