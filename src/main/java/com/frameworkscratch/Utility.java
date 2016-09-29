package com.frameworkscratch;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by maheshv on 8/22/2016.
 */
public class Utility {
    public static Logger log= Logger.getLogger(Utility.class);

    public static void verifyElementVisible(WebDriver driver, WebElement element){
        log.info("Verfying for the web element "+element.toString());
        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(element));
    }
}
