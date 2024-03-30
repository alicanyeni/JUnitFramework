package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_Locators {
    public static void main(String[] args) throws InterruptedException {

        //Chromedriveri setup ediniz.
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //sayfanin 10 saniye icinde acilip acilmadigina bakar.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com.tr");

        //cerezleri reddet butonunu idsine gore tanimlayip click eder.
        WebElement cerezler=driver.findElement(By.id("sp-cc-rejectall-link"));
        cerezler.click();

        //2 sn bekler.
        Thread.sleep(2000);

        //searchBoxu idsine gore tanımlar ve içine notebook yazip arama yapar.
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("notebook" + Keys.ENTER);

        // sayfada kac tane a tagi var onu yazdirir.
        List<WebElement> tag=driver.findElements(By.ByTagName.tagName("a"));
        System.out.println("Tag a olanlarin sayisi : "+tag.size());

        // sayfada kac tane label tagi var onu yazdirir.
        List<WebElement> label=driver.findElements(By.ByTagName.tagName("label"));
        System.out.println("Tag label olanlarin sayisi : "+label.size());

        //tarayiciyi kapatir.
        driver.quit();
    }
}
