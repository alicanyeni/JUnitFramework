package Ders05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class C04_Actions extends TestBaseBeforeAfter {

    //https://the-internet.herokuapp.com/context_menu sitesine gidelim
    //Cizgili alan bölümün uzerinde sag click yapalim
    //Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
    //Tamam diyerek alert’i kapatalim
    //Elemental Selenium linkine tiklayalim
    //Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
    @Test
    public void actionTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement hotSpot = driver.findElement(By.xpath("//div[@id='hot-spot']"));
        Actions actions = new Actions(driver);
        actions.contextClick(hotSpot).perform();

        String actualText = driver.switchTo().alert().getText();
        String expectedText = "You selected a context menu";
        Assert.assertTrue(actualText.contains(expectedText));

        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//a[contains(text(),'Elemental Selenium')]")).click();

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        driver.findElement(By.xpath("//img[@class='themedComponent_mlkZ themedComponent--light_NVdE']")).isDisplayed();
    }
}
