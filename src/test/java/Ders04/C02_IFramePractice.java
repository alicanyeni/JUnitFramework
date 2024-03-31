package Ders04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_IFramePractice {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
         driver.quit();
    }

    /*
    https://html.com/tags/iframe/ adresine gidiniz
    Youtube videosunu oynatiniz
     */
    @Test
    public void IframeTest() {
        driver.get("https://html.com/tags/iframe/");
        List<WebElement> iframe = driver.findElements(By.xpath("//iframe"));
        driver.switchTo().frame(iframe.get(0));
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();
        driver.switchTo().defaultContent();

    }
}
