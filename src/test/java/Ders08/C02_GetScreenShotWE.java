package Ders08;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;

public class C02_GetScreenShotWE extends TestBaseBeforeAfter {

    //Amazon sayfasına gidelim
    //Iphone aratalım
    //Arama sonuc yazısının resmini alalım
    @Test
    public void getScreenShotWebElement() throws InterruptedException, IOException {
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//button[@id='sp-cc-rejectall-link']")).click();

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iPhone", Keys.ENTER);

        WebElement searchResult = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        File searchResultWE = searchResult.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(searchResultWE, new File("target/WEsearchResult/WESS" + tarih + ".jpeg"));


    }
}
