package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_NavigateMethodlari {
    public static void main(String[] args) throws InterruptedException {

        //ChromeDriver'ı setup eder.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //adrese git.
        driver.navigate().to("https://www.amazon.com.tr");
        driver.navigate().to("https://www.google.com");

        //tarayiciyi tam ekran yapar.
        driver.manage().window().maximize();

        Thread.sleep(1000);

        //bir önceki sayfaya git.
        driver.navigate().back();

        //ms cinsinden bekler. 1000 ms 1 sn
        Thread.sleep(1000);

        //bir sonraki sayfaya git.
        driver.navigate().forward();

        Thread.sleep(1000);

        //sayfayi yeniler
        driver.navigate().refresh();

        //tarayiciyi kapatir.
        driver.quit();

    }
}
