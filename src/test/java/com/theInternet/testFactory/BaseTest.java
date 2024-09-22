package com.theInternet.testFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Setup Extent Reports
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("extentReport.html");
        extent.attachReporter(spark);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        extent.flush();
    }

    @AfterMethod
    public void handleTestFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test failed: " + result.getName());
            test.fail(result.getThrowable());
            // Take screenshot
            takeScreenshot(result.getName());
        }
    }

    public void takeScreenshot(String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File("screenshots//" + screenshotName + ".png");
        try {
            FileUtils.copyFile(source, destination);
            test.addScreenCaptureFromPath(destination.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

