package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_CssSelector {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
        css Selector ile sadece id ve class attributeleri locate alınabilir.
        id için basina # isareti
        class icin basina . isareti kullanilir.
         */

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElement.click();

        WebElement deleteElement = driver.findElement(By.cssSelector(".added-manually"));

        if (deleteElement.isDisplayed()){
            System.out.println("TEST PASSED *");
        } else {
            System.out.println("TEST FAILED *");
        }

        deleteElement.click();

        if(driver.findElement(By.xpath("//h3[contains(text(),'Add/Remove Elements')]")).isDisplayed()){
            System.out.println("TEST PASSED **");
        } else {
            System.out.println("TEST FAILED **");
        }

        driver.quit();
    }
}
