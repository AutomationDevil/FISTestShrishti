package org.coindesk.model;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;
    public WebPage util;

    private WebDriver initializeDriver(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeMethod
    public WebPage setDriver() {
        driver=initializeDriver();
        driver.get("https://www.ebay.com/");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        util=new WebPage(driver);
        return util;
    }
    @AfterMethod
    public void closeAllWindows(){
        driver.quit();
    }


}
