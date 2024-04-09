package Ders05;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.security.Key;

public class C07_Faker extends TestBaseBeforeAfter {

        /*
    https://www.facebook.com adresine git
    Yeni hesap olustur butonuna tikla
    Zorunlu alanlari doldur ve kaydol butonuna bas
     */

    @Test
    public void faker() throws InterruptedException {
        driver.get("https://www.facebook.com");

        WebElement create = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        Actions actions = new Actions(driver);
        actions.click(create).perform();
        Thread.sleep(3000);
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        actions.sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).perform();
        Thread.sleep(3000);
        actions.sendKeys(faker.name().lastName()).sendKeys(Keys.TAB).perform();
        Thread.sleep(3000);
        actions.sendKeys(email).sendKeys(Keys.TAB);
        Thread.sleep(3000);
        actions.sendKeys(email).sendKeys(Keys.TAB);
        Thread.sleep(3000);
        actions.sendKeys(faker.internet().password()).sendKeys(Keys.TAB).perform();
        Thread.sleep(3000);
        actions.sendKeys(faker.number().digit()).sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
        Thread.sleep(3000);
        actions.sendKeys("Eki").sendKeys(Keys.TAB).perform();
        Thread.sleep(3000);
        actions.sendKeys("1999").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ENTER).perform();


    }
}
