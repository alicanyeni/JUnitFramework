package Ders06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C04_SenkronizasyonWait extends TestBaseBeforeAfter {


    //https://the-internet.herokuapp.com/dynamic_controls adresine gidelim
    //Remove butonuna basin.
    //“It’s gone!” mesajinin goruntulendigini dogrulayin.
    //Add buttonuna basin
    //It’s back mesajinin gorundugunu test edin

    @Test
    public void implicityWait() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//button[text()='Remove']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'It')]")).isDisplayed());

        driver.findElement(By.xpath("//button[text()='Add']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//p[text()=\"It's back!\"]")).isDisplayed());

    }

    @Test
    public void explicityWait() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement itsGoneWe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));

        Assert.assertTrue(itsGoneWe.isDisplayed());

        driver.findElement(By.xpath("//*[text()=\"Add\"]")).click();

        WebElement itsbackWe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));

        Assert.assertTrue(itsbackWe.isDisplayed());
    }


}
