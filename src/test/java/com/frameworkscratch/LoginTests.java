package com.frameworkscratch;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

/**
 * Created by maheshv on 8/23/2016.
 */
public class LoginTests extends TestBase{

    Logger log= Logger.getLogger(LoginTests.class);
    public WebDriver driver;
    String mail;
    String pwd;

    @BeforeClass
    @Parameters({"username","password"})
    void startSession(String emailId, String password){
     driver=setup("Chrome");
     this.mail= emailId;
     this.pwd=password;
    }

    @Test
    public void verifyLogin() {
        UtilityLibrary utilLib=new UtilityLibrary();
        log.info(utilLib.generateRandomEmail());
        driver.get("http://gmail.com");
        SignInPage login = new SignInPage(driver);
        login.login(mail, pwd);
        HomePage home = login.clickSignIn();
        Assert.assertTrue(home.getGoogleAccountTitle().contains(mail), "Not logged in with account..." + mail);
        log.info("User logged into Gmail with :" + mail);
    }

    @AfterClass
    public void stopSession(){
        driver.quit();
    }

    /*  public static void main(String args[]){
        LoginTest test=new LoginTest();
        test.verifyLogin();
    }*/
}
