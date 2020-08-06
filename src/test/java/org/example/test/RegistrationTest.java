package org.example.test;

import org.example.pages.AuthenticationPage;
import org.example.pages.HomePage;
import org.example.pages.MyAccountPage;
import org.example.pages.RegistrationDetailsPage;
import org.example.util.Log;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class RegistrationTest extends TestBase{

    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Verify customer is able to login in")
    @Test(description = "Verify customer is able to login in")
    public void verifySuccessfulRegistrationTest() {


        HomePage homePage = new HomePage(getDriver());
        AuthenticationPage authenticationPage = new AuthenticationPage(getDriver());
        RegistrationDetailsPage registrationDetailsPage = new RegistrationDetailsPage(getDriver());
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());

        String firstname = "Leonard";
        String lastname = "Wolowitz";
        String password = "Penny!85";
        String email = "deepgoy"+Math.random()+"@gmail.com";
        Log.getLogger().debug("Email : "+email);

        homePage
                .clickSignInLink();

        authenticationPage
                .setValidEmailAddress(email)
                .clickCreateAccountButton();

        registrationDetailsPage
                .setTitleAsMr()
                .setFirstName(firstname)
                .setLastName(lastname)
                .setPassword(password)
                .setFirstNameAddress(firstname)
                .setLastNameAddress(lastname)
                .setCountry("United States")
                .setAddress("Big bang")
                .setCity("New York")
                .setState("New York")
                .setPostalCode("10001")
                .setMobilePhone("1234567890")
                .clickRegisterButton();

        Assert.assertEquals(myAccountPage.getPageHeading().toLowerCase(),"MY ACCOUNT".toLowerCase());


    }







}
