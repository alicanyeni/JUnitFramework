package Ders06;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforeAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExistDownload extends TestBaseBeforeAfter {

    //https://the-internet.herokuapp.com/download adresine gidelim.
    //test1.txt dosyasını indirelim
    //Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
    //İndirildiğini konsolda gösterin

    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[contains(text(),'test1.txt')]")).click();
        Thread.sleep(1500);
        String testPath = "/Users/alicanyeni/Downloads/test1.txt";
        Assert.assertTrue(Files.exists(Paths.get(testPath)));
        System.out.println(Paths.get(testPath));
    }
}
