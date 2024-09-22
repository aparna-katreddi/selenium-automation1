package com.theInternet.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int count = 0;

    @Override
    public boolean retry(ITestResult result) {
        int maxRetryCount = 2;
        if (count < maxRetryCount) {
            count++;
            return true;
        }
        return false;
    }
}

