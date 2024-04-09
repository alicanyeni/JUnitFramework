package Ders05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.security.Key;

public class C06_Actions extends TestBaseBeforeAfter {

    /*
    https://www.facebook.com adresine git
    Yeni hesap olustur butonuna tikla
    Zorunlu alanlari doldur ve kaydol butonuna bas
     */

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.facebook.com");

        WebElement create = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        Actions actions = new Actions(driver);
        actions.click(create).perform();
        Thread.sleep(2000);

        actions.sendKeys("ali").sendKeys(Keys.TAB)
                .sendKeys("yeni").sendKeys(Keys.TAB)
                .sendKeys("5555555555").sendKeys(Keys.TAB)
                .sendKeys("passworD12345.").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("11").sendKeys(Keys.TAB)
                .sendKeys("Eki").sendKeys(Keys.TAB)
                .sendKeys("1999").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
        Thread.sleep(1000);


    }

}
