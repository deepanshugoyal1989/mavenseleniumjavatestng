package org.example.listeners;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import io.qameta.allure.Attachment;


public class TestListenerClass implements ITestListener {


    public String getTestMethodName(ITestResult testResult){
        return testResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Failed ScreenShot", type="image/png")
    public byte[] saveScreenShot(WebDriver driver) {
       return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    @Override
    public void onStart(ITestContext iTestContext) {
      //  System.out.println("I am in onStart method " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
      //  System.out.println("I am in onFinish method " + iTestContext.getName());
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
       // System.out.println("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
       // System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
      //  System.out.println("I am in onTestFailure method " + getTestMethodName(iTestResult) + " failed");

        //Save a screenshot on allure
        saveScreenShot((WebDriver) iTestResult.getTestContext().getAttribute("driver"));

        // Save a log on allure.
        saveTextLog(getTestMethodName(iTestResult) + " failed and screenshot taken!");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
      //  System.out.println("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
      //  System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }


}
