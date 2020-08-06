package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class HomePage extends BasePage {


    // using Page Factory to initialize web elements
    @FindBy(xpath = "//a[contains(text(),'Sign in')]")
    private WebElement signInLink;

    @FindBy(xpath="//a[text()='Women']")
    private WebElement womenMenuLink;

    @FindBy(xpath="//ul[contains(@class,'submenu-container')]/descendant::a[@title='Summer Dresses']")
    private WebElement summerDressesSubMenuLink;

    @FindBy(xpath = "//ul[contains(@class,'product_list')]/li[not(contains(@class,'last-in-line')) and not(contains(@class,'first-in-line'))]")
    private WebElement middleSummerDress;
    @FindBy(xpath="//ul[contains(@class,'product_list')]/li[not(contains(@class,'last-in-line')) and not(contains(@class,'first-in-line'))]//div[@class='wishlist']")
    private WebElement middleSummerDressAddToWishlistLink;

    @FindBy(xpath="//p[@class='fancybox-error']")
    private WebElement loggedInMessage;

    //initialize driver with web elements of the page
    public HomePage(WebDriver driver) {
        super(driver);
    }
//You must be logged in to manage your wishlist.

   @Step("Step: Click on Sign-in on home page")
    public HomePage clickSignInLink() {
        clickButton(signInLink);
        return this;
    }

    @Step("Step: Hover over women menu and click on summer dresses link in sub menu")
    public HomePage hoverOverWomenLinkAndClickSummerDressesLink(){
        hoverOnMainWebElementAndClickSubWebElement(womenMenuLink,summerDressesSubMenuLink);
        return this;
    }

    @Step("Step: Hover over middle dress and click on add to wishlist button")
    public HomePage hoverOverMiddleDressAndClickAddToWishList() {
        hoverOnMainWebElementAndClickSubWebElement(middleSummerDress,middleSummerDressAddToWishlistLink);
        return this;

    }

    @Step("Step: Hover over women menu and click on summer dresses link in sub menu")
    public String getLoggedInMessage() {
        return getWebElementText(loggedInMessage);
    }

    @Step("Step: Get home page title")
    public String getHomePageTitle() {
        return getTitle();
    }
}
