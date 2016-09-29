package com.frameworkscratch;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by maheshv on 8/22/2016.
 */
public class TestBase {
    Logger log= Logger.getLogger(TestBase.class);
    public WebDriver driver;
    String browser;

    public WebDriver setup(String browser) {
        if(browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        if(browser.equalsIgnoreCase("Firefox"))
        {
            driver = new FirefoxDriver();
        }
        log.info("Chrome browser opened");
        driver.manage().window().maximize();
        return driver;
    }
}
