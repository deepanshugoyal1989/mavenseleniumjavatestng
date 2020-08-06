package org.example.test;

import org.example.listeners.TestListenerClass;
import org.example.pages.HomePage;
import org.example.util.Log;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

/**
 * This Test confirms that we landed on home page successfully
 */

public class HomePageTest extends TestBase {

    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Verify that customer is on home page")
    @Test(description = "Verify that customer is on home page")
    public void homePageTest() {

        Log.getLogger().warn("Running home Page Test");
        HomePage homePage = new HomePage(getDriver());
        Assert.assertEquals(homePage.getHomePageTitle(), "My Store","Home page title mismatch");

    }
}
