package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class C01_DriverMethodlari {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //tırnak içindeki adrese gider.
        driver.get("https://www.amazon.com.tr/");

        //sayfayı maximum boyuta getirir.
        driver.manage().window().maximize();

        //Sayfanin basligini getirir.
        System.out.println("Sayfanin basligi :" + driver.getTitle());

        //Sayfanin url adresini yazdirir.
        System.out.println("Sayfanin URL adresi :" + driver.getCurrentUrl());

        //Sayfanin kaynak kodlarini yazdirir.(inspect kodlari)
        // System.out.println("Sayfanin kaynak kodlari :"+driver.getPageSource());

        //Sayfanin kaynak kodunu actualData objesine atıyoruz.
        String actualData = driver.getPageSource();

        //Sayfanin kaynak kodunda arayacağımız kelimeyi expectedData objesinin içine atıyoruz.
        String expectedData = "Gateway";

        //Kaynak kodlarin arasinda aradigimiz kelime var mi bakiyoruz.
        if (actualData.contains(expectedData)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        //Sayfanin window handle kodunu yazdirir.
        System.out.println("Window Handle: " + driver.getWindowHandle());

        //Sayfayi kapatir
        driver.close();
    }
}
