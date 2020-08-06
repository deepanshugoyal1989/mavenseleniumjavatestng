package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver){
        //My account - My Store
        super(driver);
    }

    @FindBy(xpath="//div[@id='center_column']/h1[@class='page-heading']")
    private WebElement pageHeadingText;

    @Step("Step: Get my account page heading")
    public String getPageHeading() {
        return getWebElementText(pageHeadingText);
    }

    @Step("Step: Get my account page title")
    public String getMyAccountPageTitle() {
        return getTitle();
    }

}
