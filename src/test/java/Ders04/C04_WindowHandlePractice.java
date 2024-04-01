package Ders04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_WindowHandlePractice {
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

    //1- Amazon Sayfasina girelim
    //2- Url'nin amazon içerdiğini test edelim
    //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
    //4- title'in Best Buy içerdiğini test edelim
    //5- İlk sayfaya dönüp sayfada java aratalım
    //6- Arama sonuclarının java içerdiğini test edelim
    //7- Yeniden bestbuy sayfasına gidelim
    //8- Logonun görünürlüğünü test edelim
    @Test
    public void windowHandleTest() throws InterruptedException {
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.xpath("//button[@id='sp-cc-rejectall-link']")).click();
        Thread.sleep(1000);

        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));

        String amazonWindowHandle = driver.getWindowHandle();
        System.out.println(amazonWindowHandle);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle = driver.getWindowHandle();
        String actualTitle = driver.getTitle();
        String expectedTitle = "Best Buy";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys("java" + Keys.ENTER);
        driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']"));
        Assert.assertTrue(driver.findElement(By.xpath("//span[@class='a-color-state a-text-bold']")).getText().contains("java"));

        driver.switchTo().window(bestBuyWindowHandle);
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]")).isDisplayed());

    }
}
