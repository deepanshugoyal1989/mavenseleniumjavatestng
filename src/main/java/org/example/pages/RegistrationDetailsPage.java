package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationDetailsPage extends BasePage {

    public RegistrationDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='radio' and @id='id_gender1']")
    private WebElement mrTitleRadioButton;

    @FindBy(xpath = "//input[@type='radio' and @id='id_gender2']")
    private WebElement mrsTitleRadioButton;

    @FindBy(xpath = "//input[contains(@name,'customer_firstname')]")
    private WebElement firstNameTextBox;

    @FindBy(xpath="//input[contains(@name,'customer_lastname')]")
    private WebElement lastNameTextBox;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailTextBox;

    @FindBy(xpath = "//div[contains(@class,'password')]/child::input")
    private WebElement passwordTextBox;

    @FindBy(xpath="//div[contains(@class,'account_creation')]/descendant::input[@id='firstname']")
    private WebElement firstNameAddressTextBox;

    @FindBy(xpath="//label[@for='lastname']/following-sibling::input")
    private WebElement lastNameAddressTextBox;

   @FindBy(xpath="//input[@id='address1']")
    private WebElement addressTextBox;

   @FindBy(xpath="//input[contains(@id,'city')]")
   private WebElement cityTextBox;

   @FindBy(xpath="//select[@id='id_state']")
   private WebElement stateDropDown;

   @FindBy(xpath="//input[@type='text' and @name='postcode']")
   private WebElement postalCodeTextBox;

   @FindBy(xpath="//select[@name='id_country']")
   private WebElement countryDropDown;

   @FindBy(name="phone_mobile")
   private WebElement mobilePhoneTextBox;

   @FindBy(id="submitAccount")
   private WebElement registerButton;


   public RegistrationDetailsPage setTitleAsMr() {
       clickRadioButton(mrTitleRadioButton);
       return this;
   }

    public RegistrationDetailsPage setTitleAsMrs() {
       clickRadioButton(mrsTitleRadioButton);
        return this;
   }

    public RegistrationDetailsPage setFirstName(String firstName) {
        writeToTextBox(firstNameTextBox,firstName);
        return this;
    }

    public RegistrationDetailsPage setLastName(String lastName) {
        writeToTextBox(lastNameTextBox,lastName);
        return this;
    }

    public RegistrationDetailsPage setPassword(String password) {
       writeToTextBox(passwordTextBox,password);
        return this;
    }

    public RegistrationDetailsPage setCountry(String country) {
       selectFromDropDown(countryDropDown,country);
        return this;
    }

    public RegistrationDetailsPage setFirstNameAddress(String firstNameAddress) {
       writeToTextBox(firstNameAddressTextBox,firstNameAddress);
        return this;
    }

    public RegistrationDetailsPage setLastNameAddress(String lastNameAddress) {
       writeToTextBox(lastNameAddressTextBox,lastNameAddress);
        return this;
    }

    public RegistrationDetailsPage setAddress(String address) {
       writeToTextBox(addressTextBox,address);
        return this;
    }

    public RegistrationDetailsPage setCity(String city) {
       writeToTextBox(cityTextBox,city);
        return this;
    }

    public RegistrationDetailsPage setState(String state) {
       selectFromDropDown(stateDropDown,state);
        return this;
    }

    public RegistrationDetailsPage setPostalCode(String postalCode) {
       writeToTextBox(postalCodeTextBox,postalCode);
        return this;
    }

    public RegistrationDetailsPage setMobilePhone(String mobilePhone) {
       writeToTextBox(mobilePhoneTextBox,mobilePhone);
        return this;
    }

    public RegistrationDetailsPage clickRegisterButton(){
       clickButton(registerButton);
        return this;
    }

    public String getRegistrationDetailsPageTitle() {
       return getTitle();
    }
 }
