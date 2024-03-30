package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {

    /*
    "https://the-internet.herokuapp.com/dropdown" adresine git
    Index kullanarak Option 1i seçin ve yazdırın
    Value kullanarak option 2yi seçin ve yazdırın
    Visible Text kullanarak Option 1i ve Option 2yi seçin ve yazdırın
    Tüm dropdown degerlerini yazdırın
    Dropdownun boyutunu bulun, dropdownda 4 öge varsa konsolda true degilse false yazdırın.
     */

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

    @Test
    public void dropDownTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropDown = driver.findElement(By.cssSelector("#dropdown"));
        Select select = new Select(dropDown);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("========================");
        Thread.sleep(1000);

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("========================");
        Thread.sleep(1000);

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("========================");
        Thread.sleep(2000);

        select.selectByVisibleText("Option 2");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("========================");
        Thread.sleep(1000);

        List<WebElement> allDdm = driver.findElements(By.xpath("//option"));
        for (WebElement w : allDdm) {
            System.out.println(w.getText());
        }
        Thread.sleep(1000);
        System.out.println("========================");

        if (allDdm.size() == 4) {
            System.out.println("True");
        } else {
            System.out.println("False. DropDown Size = " + allDdm.size());
        }

    }
}
