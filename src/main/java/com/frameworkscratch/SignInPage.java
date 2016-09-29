package com.frameworkscratch;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by maheshv on 8/23/2016.
 */
public class SignInPage {
    Logger log= Logger.getLogger(SignInPage.class);

    @FindBy(id="Email")
    WebElement email;

    @FindBy(id="next")
    WebElement next;

    @FindBy(id="Passwd")
    WebElement password;

    @FindBy(id="signIn")
    WebElement signIn;

    public WebDriver driver;

    public SignInPage(WebDriver driver){
        this.driver=driver;
        AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver,100);
        PageFactory.initElements(factory,this);
    }

    public void enterEmail(String mail){
       email.sendKeys(mail);
        log.info("enter mail address");
    }

    public void enterPassword(String pwd){
        Utility.verifyElementVisible(driver,password);
        password.sendKeys(pwd);
        log.info("enter password");
    }

    public void login(String mail, String pwd){
        enterEmail(mail);
        clickNext();
        enterPassword(pwd);
        log.info("Clicked on sign in button");
    }

    public void clickNext(){
        next.click();
        log.info("Clicked on next");
    }

    public HomePage clickSignIn(){
        signIn.click();
        log.info("Clicked on Sign in and navigated to Home page");
        return new HomePage(driver);
    }
}
