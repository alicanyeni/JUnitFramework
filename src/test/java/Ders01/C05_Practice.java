package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.ref.WeakReference;

public class C05_Practice {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");

        if (driver.getTitle().contains("facebook")) {
            System.out.println("Title is true");
        } else {
            System.out.println("Actual Title = " + driver.getTitle());
        }

        if (driver.getCurrentUrl().contains("facebook")) {
            System.out.println("CurrentUrl is true");
        } else {
            System.out.println("Actual CurrentUrl = " + driver.getCurrentUrl());
        }

        driver.navigate().to("https://www.walmart.com/");

        if (driver.getTitle().contains("Walmart.com")) {
            System.out.println("Title2 is true");
        } else {
            System.out.println("Actual Title = " + driver.getTitle());
        }

        Thread.sleep(1000);
        driver.navigate().back();

        Thread.sleep(1000);
        driver.navigate().refresh();

        Thread.sleep(1000);
        driver.manage().window().maximize();

        driver.quit();
    }
}
