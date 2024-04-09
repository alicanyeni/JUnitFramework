package Ders05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class C03_Actions extends TestBaseBeforeAfter {


    /*
    https://www.amazon.com.tr/ sayfasina gidelim
    Hesaplar menusunden liste olusturun linkine tiklayalim.
    Arama kutusuna actions methodlarini kullanarak iPhone 15 Plus yazdırın ve Entera basarak arama yaptırın.
    Aramanin gerceklestigini test edin.
     */
    @Test
    public void actionTests() throws InterruptedException {
        driver.get("https://www.amazon.com.tr/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='sp-cc-rejectall-link']")).click();

        WebElement hesaplar = driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1"));
        WebElement listeolustur = driver.findElement(By.xpath("(//*[@class='nav-text'])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hesaplar).click(listeolustur).perform();


        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        actions.click(searchBox).keyDown(Keys.SHIFT).sendKeys("ı").keyUp(Keys.SHIFT).sendKeys("phone").sendKeys(" ").sendKeys("15")
                .sendKeys(" ").keyDown(Keys.SHIFT).sendKeys("p").keyUp(Keys.SHIFT).sendKeys("lus").sendKeys(Keys.ENTER).perform();

        String actualdata = driver.getTitle();
        String expecteddata = "Iphone 15 Plus";
        Assert.assertTrue(actualdata.contains(expecteddata));
    }
}
