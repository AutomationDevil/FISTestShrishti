package ebay;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Test
public class CartTest {
 WebDriver driver= new ChromeDriver();

 public void addToCart(){
  driver.get("https://www.ebay.com/");
  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.manage().window().maximize();
  driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("book");
  driver.findElement(By.cssSelector("input.btn.btn-prim.gh-spr")).click();
     WebElement firstElement=driver.findElement(By.xpath("//ul[@class='srp-results srp-list clearfix']/li[2] //div[@class='s-item__title']"));
     System.out.println(firstElement.getText());
     firstElement.click();
     Set<String> handles=driver.getWindowHandles();
     Iterator<String> it= handles.iterator();
     while(it.hasNext()){
         driver.switchTo().window(it.next());
         System.out.println(driver.getTitle());
     }
     JavascriptExecutor js=  (JavascriptExecutor) driver;
     js.executeScript("window.scrollBy(0,200)");
     driver.findElement(By.cssSelector("#atcBtn_btn_1")).click();
     String i=driver.findElement(By.xpath("//li[@id='gh-minicart-hover']//div/a[1]/i")).getText();
     driver.findElement(By.xpath("//li[@id='gh-minicart-hover']//div/a[1]")).click();
     Assert.assertNotNull(i);
     driver.quit();
 }
}
