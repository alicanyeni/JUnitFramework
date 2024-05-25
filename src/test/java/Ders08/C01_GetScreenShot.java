package Ders08;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;


public class C01_GetScreenShot extends TestBaseBeforeAfter {

    @Test
    public void GetScreenShot() throws IOException {
        driver.get("https://www.bestbuy.com");

        TakesScreenshot screenshot=(TakesScreenshot) driver;
        File tumSayfa=screenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfa,new File("target/ekranGoruntusu/AllPage"+tarih+".jpeg"));
    }
}
