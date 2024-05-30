package Ders08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C03_JSExucator extends TestBaseBeforeAfter {

    //Amazon sayfasına gidelim
    //Aşağıdaki carrers butonunu görünceye kadar js ile scroll yapalım
    //Carrers butonuna js ile click yapalım

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='sp-cc-rejectall-link']")).click();

        WebElement careerButton = driver.findElement(By.xpath("//a[contains(text(),'Kariyer')]"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true)", careerButton);

        js.executeScript("arguments[0].click();", careerButton);

        Thread.sleep(3000);
    }
}
