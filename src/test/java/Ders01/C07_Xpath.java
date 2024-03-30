package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Xpath {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(2000);

        WebElement addEelement= driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addEelement.click();

        WebElement deleteElement = driver.findElement(By.xpath("//*[text()='Delete']"));

        if(deleteElement.isDisplayed()){
            System.out.println("TEST PASSED *");
        }
        else {
            System.out.println("TEST FAILED *");
        }
        Thread.sleep(1000);
        deleteElement.click();

        if(driver.findElement(By.xpath("//*[text()='Add/Remove Elements']")).isDisplayed()){
            System.out.println("TEST PASSED **");
        }  else {
            System.out.println("TEST FAILED **");
        }

        Thread.sleep(2000);

        driver.quit();

    }
}
