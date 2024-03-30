package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class C03_ManageMethodlari {
    public static void main(String[] args) throws InterruptedException {

        //ChromeDriver setup ediliyor.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //adrese git
        driver.get("https://www.amazon.com.tr/");

        //sayfanın konumunu ve boyutlarını yazdır.
        System.out.println("Sayfanin konumu :" + driver.manage().window().getPosition());
        System.out.println("Sayfanin boyutu :" + driver.manage().window().getSize());

        //sayfayi simge durumuna getir.
        driver.manage().window().minimize();

        //iki saniye bekle ve sayfayi maximize et
        Thread.sleep(2000);
        driver.manage().window().maximize();

        //sayfayi fullscreen yap
        Thread.sleep(2000);
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
        driver.manage().window().maximize();

        //sayfanin konumunu ve boyutunu fullscreen haldeyken yazdirin
        System.out.println("Sayfanin fullscreen konumu" + driver.manage().window().getPosition());
        System.out.println("Sayfanin fullscreen boyutu" + driver.manage().window().getSize());

        //sayfanin boyutunu ve konumunu istedigin sekilde ayarla.
        Thread.sleep(4000);
        driver.manage().window().setPosition(new Point(25, 25));
        driver.manage().window().setSize(new Dimension(1000, 600));
        Thread.sleep(4000);

        //sayfanin istenilen konum ve boyutuna gelip gelmedigini test et
        System.out.println("Sayfanin istenilen konumu" + driver.manage().window().getPosition());
        System.out.println("Sayfanin istenilen boyutu" + driver.manage().window().getSize());

        //tarayiciyi kapatir.
        driver.quit();

    }


}
