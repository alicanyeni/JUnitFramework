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

public class C01_IFrame {
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
    Iframe adında bir metod oluştur.
    https://the-internet.herokuapp.com/iframe adresine git.
    "An iFrame containing" textinin erişilebilir oldugunu test et ve console'a yazdır.
    textBox'a Merhaba Dünya! yazdır.
    textBox'un altında bulunan "Elemental Selenium" linkinin textinin görünür oldugunu kontrol et ve console'a yazdır.
     */

    @Test
    public void IframeTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/iframe");

        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//h3")).getText());

        WebElement iFrameTextBox = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrameTextBox);

        WebElement textBox = driver.findElement(By.xpath("//p"));
        textBox.clear();
        Thread.sleep(2000);
        textBox.sendKeys("Merhaba Dunya!");
        Thread.sleep(2000);

        //driver.switchTo().parentFrame(); // Bir ust seviyedeki frame'e gecis yapar.
        driver.switchTo().defaultContent(); // En ust seviyedeki frame'e gecis yapar.

        WebElement a = driver.findElement(By.xpath("//a[contains(text(),'Elemental Selenium')]"));
        Assert.assertTrue(a.isDisplayed());
        System.out.println(a.getText());

    }
}
