package Ders04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C03_WindowHandle {

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

    //https://the-internet.herokuapp.com/windows adresine gidin.
    //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    //Click Here butonuna basın.
    //Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    //Sayfadaki textin “New Window” olduğunu doğrulayın.
    //Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

    @Test
    public void windowHandle() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        String hoappWindowHandle = driver.getWindowHandle();
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        Assert.assertTrue(driver.getTitle().contains("The Internet"));

        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        List<String> windowList = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        System.out.println("windowList = " + windowList);
        Thread.sleep(1000);
        String expectedTitle = "New Window";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

        driver.switchTo().window(windowList.get(0));
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
    }
}
