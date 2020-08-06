package org.example.test;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.util.Log;
import org.example.util.ReadProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase {

    ReadProperties readProperties = new ReadProperties();
    private WebDriver driver;


    @BeforeMethod
    public void setUp(ITestContext iTestContext){


            if ("chrome".equals(readProperties.getProperty("BROWSER"))) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                Log.getLogger().info("Browser:Chrome is used for testing");
            }
            driver.get(readProperties.getProperty("APPLICATION_URL"));
            Log.getLogger().info("Application Url : "+readProperties.getProperty("APPLICATION_URL")+" is opened in browser.");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            iTestContext.setAttribute("driver",driver);
            Log.getLogger().info("Window maximized and cookies are deleted");

    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) {
        Log.getLogger().info("Quiting Driver");
        driver.quit();

    }

    public WebDriver getDriver() {
        return driver;
    }

}
