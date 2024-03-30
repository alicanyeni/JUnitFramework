package Ders02;

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

import static java.lang.Thread.*;
import static org.openqa.selenium.By.xpath;

public class C05_RadioButton {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.facebook.com");
        WebElement createNewButton = driver.findElement(By.xpath("//*[@class=\"_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy\"]"));
        createNewButton.click();

        WebElement firstName = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[1]"));
        WebElement lastName = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[2]"));
        WebElement mail = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[3]"));
        WebElement remail = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[4]"));
        WebElement newPassword = driver.findElement(By.xpath("(//*[@class='inputtext _58mg _5dba _2ph-'])[5]"));
        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        WebElement genderFemale = driver.findElement(By.xpath("(//input[@name='sex'])[1]"));
        WebElement genderMale = driver.findElement(By.xpath("(//input[@name='sex'])[2]"));


        firstName.sendKeys("ali can");
        lastName.sendKeys("yeni");
        mail.sendKeys("yeni@yeni.com");
        remail.sendKeys("yeni@yeni.com");
        newPassword.sendKeys("!yeni@yeni.com");
        //sendKey ile 11 i seçemedim. Kendim farklı bir yöntem kullandım kurstan bağımsız.
        Select daySelect = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        daySelect.selectByVisibleText("11");
        month.sendKeys("Oct");
        year.sendKeys("1999");

        if (!genderMale.isSelected()) {
            genderMale.click();
        }

        genderFemale.click();

        Thread.sleep(3000);
    }
}
