package org.example.listeners;

import org.example.util.Constants;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerListenerClass implements IRetryAnalyzer {
    private int count=0;


    @Override
    public boolean retry(ITestResult result) {

        if(count< Constants.MAXTRY) {
            count++;
            return true;
        }
        return false;
    }
}
