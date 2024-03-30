package Ders03;

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

public class C02_Assertions {

    WebDriver driver;

    /*
    https://www.youtube.com adresine git.
    Asagidaki adlari kullanarak 4 test methodu olusturun ve gerekli testleri yazin.
    titleTest => sayfa basliginin Youtube oldugunu test edin.
    imageTest => youtube resminin goruntulenmesini test edin.
    searchBox in erisebilir oldugunu test edin.
    wrongTitleTest => Sayfa basliginin youtube olmadıgini test edin.
     */

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void titleTest() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @Test
    public void imageTest() {
        WebElement icon = driver.findElement(By.xpath("(//icon-shape[@class='yt-spec-icon-shape'])[5]"));
        Assert.assertTrue(icon.isDisplayed());
    }

    @Test
    public void searchBoxTest() {
        WebElement searchBox = driver.findElement(By.xpath("(//*[@id='search'])[2]"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Youtube";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
}
