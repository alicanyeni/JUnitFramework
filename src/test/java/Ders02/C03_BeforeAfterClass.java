package Ders02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfterClass {
   static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    /*
    BeforeClass AfterClass her bir test anatasyonu için farklı tarayıcı açmaz tek tarayıcıda testleri koşar.
     */

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void test() {
        driver.get("https://www.amazon.com.tr");
    }

    @Test
    public void test2() {
        driver.get("https://www.facebook.com");
    }
}
