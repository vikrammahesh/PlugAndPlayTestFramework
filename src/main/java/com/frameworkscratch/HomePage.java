package com.frameworkscratch;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by maheshv on 8/23/2016.
 */
public class HomePage {

    SignInPage login;
    Logger log= Logger.getLogger(HomePage.class);

    @FindBy(xpath="//div[text()='COMPOSE']")
    WebElement compose;

    @FindBy(css ="a[title*='Google Account:']")
    WebElement title;

    @FindBy(xpath="//a[text()='Sign out']") WebElement signout;

    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        AjaxElementLocatorFactory factory=new AjaxElementLocatorFactory(driver,100);
        PageFactory.initElements(factory,this);
    }

    public String getGoogleAccountTitle(){
        log.info("Captured account title");
        return title.getAttribute("title");
    }

    public void clickSignout(){
        Utility.verifyElementVisible(driver,title);
        title.click();
        Utility.verifyElementVisible(driver,signout);
        signout.click();
    }

}
