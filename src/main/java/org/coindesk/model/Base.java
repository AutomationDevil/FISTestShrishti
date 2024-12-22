package org.coindesk.model;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver = new ChromeDriver();

    @BeforeGroups(groups = "ui")
    public void setDriver() {
        driver.get("https://www.ebay.com/");
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @AfterGroups("ui")
    public void closeAllWindows(){
        driver.quit();
    }


}
