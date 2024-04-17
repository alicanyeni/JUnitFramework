package Ders06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C03_FileExistUpload extends TestBaseBeforeAfter {

    //https://the-internet.herokuapp.com/upload adresine gidelim
    //Dosyasec butonuna basalim
    //Yuklemek istediginiz dosyayi secelim.
    //Upload butonuna basalim.
    //“File Uploaded!” textinin goruntulendigini test edelim.

    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.xpath("//input[@id='file-upload']"));
        String file = "/Users/alicanyeni/Desktop/moon.jpeg";
        chooseFile.sendKeys(file);
        Thread.sleep(1000);
        WebElement uploadFile = driver.findElement(By.xpath("//input[@id='file-submit']"));
        uploadFile.click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
