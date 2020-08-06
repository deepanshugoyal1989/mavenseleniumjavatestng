package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class AuthenticationPage extends BasePage {


    public AuthenticationPage(WebDriver driver) {

        super(driver);

    }

    @FindBy(xpath="//input[@type='text' and @id='email_create']")
    private WebElement accountCreationEmailTextBox;

    @FindBy(xpath = "//button[@id='SubmitCreate']")
    private WebElement createAccountButton;


    @Step("Step: Provide valid email for registration - {0}")
    public AuthenticationPage setValidEmailAddress(String emailAddress) {

        writeToTextBox(accountCreationEmailTextBox,emailAddress);
        return this;
    }

    @Step("Step: Click on Create Button on authenticate page")
    public AuthenticationPage clickCreateAccountButton() {
        clickButton(createAccountButton);
        return this;
    }
    @Step("Step: Get authentication page title")
    public String getAuthenticationPageTitle(){
        return getTitle();
    }
}
