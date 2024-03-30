package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_DropDownPractice {

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
    Amazona git.
    Çerezleri kabul etmeden devam et seçeneğini seç.
    Arama kutusunun yanindaki kategori menusunun kategori sayisinin 40 oldugunu test et.
    Kategori menusunden "Kitaplar" secenegini secin.
    Arama kutusuna java yazin.
    Bulunan sonuc sayisini yazdirin.
    Sonucun Java kelimesini icerdigini test edin.
     */

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com.tr");
        WebElement ignoreCookies = driver.findElement(By.xpath("//*[@id='sp-cc-rejectall-link']"));
        ignoreCookies.click();

        List<WebElement> ddm = driver.findElements(By.xpath("//select[@aria-describedby='searchDropdownDescription']//option"));
        for (WebElement w : ddm) {
            System.out.println(w.getText());
        }
        int actualDdc = ddm.size();
        int expectedDdc = 40;
        Assert.assertNotEquals(expectedDdc, actualDdc);

        WebElement dropDown = driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select categorySelect = new Select(dropDown);
        categorySelect.selectByVisibleText("Kitaplar");

        WebElement searchBar = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBar.sendKeys("java", Keys.ENTER);
        Thread.sleep(2000);

        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println("Result  Size = " + result.getText());

        String actualText = result.getText();
        String expectedText = "java";
        Assert.assertTrue(actualText.contains(expectedText));

    }
}
