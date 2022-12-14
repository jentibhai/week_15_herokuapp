package com.herokuapp.pages;

import com.herokuapp.utility.Utility;
import javafx.scene.control.PasswordField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import sun.security.util.Password;

import static org.bouncycastle.cms.RecipientId.password;

public class Loginpage extends Utility {

    //By UsernameField = By.id("username");

    @CacheLookup
    @FindBy(id = "username")
    WebElement UsernameField;

    public void enterUserName(String Username) {
        Reporter.log("enterUserName" + UsernameField.toString());
        sendTextToElement(UsernameField, Username);}

        @CacheLookup
        @FindBy(id = "password")
        WebElement passwordfield;
        public void enterPassword(String password){
            Reporter.log("enterpassword"+passwordfield.toString());
            sendTextToElement(passwordfield,password);}





        @CacheLookup
        @FindBy(xpath = "//button[@type='submit']")
        WebElement loginButton;
        public void clickOnLoginButton () {
            Reporter.log("clickOnLoginButton" + loginButton.toString());
            clickOnElement(loginButton);
        }


        @CacheLookup
        @FindBy(xpath = "//h2[normalize-space()='Secure Area']")
        WebElement errorMessage;

        public String getErrorMessage () {
            Reporter.log("getErrorMessage"+errorMessage.toString());

            return getTextFromElement(errorMessage);
        }

        //By errorMessage1 =By.xpath("//div[contains(text(),'Your username is invalid!')]");
        @CacheLookup
        @FindBy(xpath = "//div[contains(text(),'Your username is invalid!')]")
        WebElement errorMessage1;

        public String getErrorMessage1 () {
            Reporter.log("getErrorMessage1"+errorMessage1.toString());
            return getTextFromElement(errorMessage1);
        }

        //By errorMessage2 =By.xpath("//div[contains(text(),'Your password is invalid!')]");
        @CacheLookup
        @FindBy(xpath = "//div[contains(text(),'Your password is invalid!')]")
        WebElement errorMessage2;

        public String getErrorMessage2 () {
            Reporter.log("getErrorMessage2"+errorMessage2.toString());
            return getTextFromElement(errorMessage2);
        }
    }

