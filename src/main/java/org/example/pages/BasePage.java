package org.example.pages;

import org.example.util.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {


    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Constants.TIMEOUTINSECONDS, Constants.POLLINGAFTEREVERYMILLISECONDS);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,Constants.TIMEOUTINSECONDS),this);

    }

    protected void waitForElementToAppear(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));

    }

    protected void clickButton(WebElement buttonWebElement){
        buttonWebElement.click();
    }

    protected void clickRadioButton(WebElement radioButtonWebElement) {
        radioButtonWebElement.click();
    }

    protected void writeToTextBox(WebElement textBoxWebElement, String txt) {
        textBoxWebElement.sendKeys(txt);
    }

    protected void selectFromDropDown(WebElement dropdownWebElement, int index) {
        Select dropdown = new Select(dropdownWebElement);
        dropdown.selectByIndex(index);
    }

    protected void selectFromDropDown(WebElement dropdownWebElement, String visibleText) {
        Select dropdown = new Select(dropdownWebElement);
        dropdown.selectByVisibleText(visibleText);
    }

    protected String getWebElementText(WebElement element) {
        return element.getText();
    }

    protected void hoverOnMainWebElementAndClickSubWebElement(WebElement mainElement, WebElement subElement) {
        Actions action = new Actions(driver);
        action.moveToElement(mainElement).perform();
        waitForElementToAppear(subElement);
        action.moveToElement(subElement).click().perform();
    }

    protected String getTitle() {
        return driver.getTitle();
    }


}
