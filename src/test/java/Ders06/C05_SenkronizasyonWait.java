package Ders06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeAfter;

import java.time.Duration;

public class C05_SenkronizasyonWait extends TestBaseBeforeAfter {

    //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //Textbox’in etkin olmadigini(enabled) dogrulayın
    //Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    //“It’s enabled!” mesajinin goruntulendigini dogrulayın.
    //Textbox’in etkin oldugunu(enabled) dogrulayın.


    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement input = driver.findElement(By.xpath("//input[@type='text']"));

        Assert.assertFalse(input.isEnabled());

        driver.findElement(By.xpath("//*[text()='Enable']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(input));

        Assert.assertTrue(driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]")).isDisplayed());

        Assert.assertTrue(input.isEnabled());
    }
}
