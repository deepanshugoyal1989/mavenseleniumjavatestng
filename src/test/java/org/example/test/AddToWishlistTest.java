package org.example.test;

import org.example.pages.HomePage;
import org.example.util.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class AddToWishlistTest extends TestBase {

    @Severity(SeverityLevel.MINOR)
    @Description("Test Description: Verify that customer is not able to add item/s to wishlist without login in")
    @Test(description = "Verify that customer is not able to add item/s to wishlist without login in")
    public void verifyNotAbleToAddToWishlistWithoutLoginTest() {

        HomePage homePage = new HomePage(getDriver());

        homePage
                .hoverOverWomenLinkAndClickSummerDressesLink()
                .hoverOverMiddleDressAndClickAddToWishList();

        Log.getLogger().error("Text doesn't match");
        Assert.assertEquals(homePage.getLoggedInMessage(),"You must be logged in to manage your wishlist.");

    }

}
