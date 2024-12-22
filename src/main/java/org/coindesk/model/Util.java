package org.coindesk.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.Iterator;
import java.util.Set;

public class Util  {
    WebDriver driver;
    int numberOfItem;

    public Util(WebDriver driver) {
        this.driver=driver;
    }

    public void searchItem(int i){
        if(i!=0){
        driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("book");
        driver.findElement(By.cssSelector("input.btn.btn-prim.gh-spr")).click();//search
        WebElement book= driver.findElement(By.xpath("//ul[@class='srp-results srp-list clearfix']/li["+(i+1)+"] //div[@class='s-item__title']"));
        this.numberOfItem=i;
        book.click();}else{throw new RuntimeException("add atleast one item");}
    }

    public void switchTabs(){
        Set<String> handles=driver.getWindowHandles();
        Iterator<String> it= handles.iterator();
        while(it.hasNext()){
            driver.switchTo().window(it.next());
        }
    }
    public void addToCart(){
        JavascriptExecutor js=  (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        driver.findElement(By.cssSelector("#atcBtn_btn_1")).click();
        int actualItem= Integer.parseInt(driver.findElement(By.xpath("//li[@id='gh-minicart-hover']//div/a[1]/i")).getText());
        driver.findElement(By.xpath("//li[@id='gh-minicart-hover']//div/a[1]")).click();
        Assert.assertEquals(actualItem,numberOfItem);
    }

}
