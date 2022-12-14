package com.herokuapp.testsuite;

import com.herokuapp.pages.Loginpage;
import com.herokuapp.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {



    Loginpage loginPage ;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){loginPage=new Loginpage();}

    @Test (groups={"sanity","regression"})

    public void UserSholdLoginSuccessfullyWithValidCredentials(){


        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String expectedText ="Secure Area";
        String actualText =loginPage.getErrorMessage();
        Assert.assertEquals(actualText,expectedText,"Secure Area");

    }

    @Test(groups = {"smoke","regression"})

    public void verifyTheUsernameErrorMessage(){

        loginPage.enterUserName("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        String expectedText ="Your username is invalid!\n" +
                "×";
        String actualText =loginPage.getErrorMessage1();
        Assert.assertEquals(actualText,expectedText,"Your username is invalid! ");

    }

    @Test(groups={"regression","regrssion"})

    public void verifyThePasswordErrorMessage(){



        loginPage.enterUserName("tomsmith");
        loginPage.enterPassword("kk");
        loginPage.clickOnLoginButton();
        String expectedText ="Your password is invalid!\n" +
                "×";
        String actualText =loginPage.getErrorMessage2();
        Assert.assertEquals(actualText,expectedText,"Your password is invalid!");

    }
}



