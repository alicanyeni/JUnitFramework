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

public class C05_Allerts {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    /*
    Bir websitesine girdiğimizde ya da bir butona tıkladığımızda karşımıza bir uyarı çıkabilir.
    Eğer uyarıya inspect yapabiliyorsak bu tür alertlere HTML alert denir ve istediğimiz locate'i
    alabiliriz ancak gelen uyarı tasarımına inspect atamıyorsak bu tür alertlere JS Alert denir. JS
    Alertlere inspect atabilmek için
    - tamam ya da ok için driver.switchTo().alert().accept() kullanılır
    - iptal için driver.switchTo().alert().dismiss() methodu kullanılır.
    - Alert içindeki mesajı almak için driver.switchTo().alert().getText() kullanılır.
    - Alert bizden bir metin istiyorsa driver.switchTo().alert().sendKeys("") kullanılır.
     */

    /*
    https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    Bir acceptAlert metodu olusturun
    1. butona tıklayın uyarıdaki OK butonuna tıklayın ve result mesajının "You successfully clicked an alert" oldugunu test edin.
    2. butona tıklayın uyarıdaki cansel butonuna tıklayın ve result mesajının "successfully" içermediğini test et ve alert üzerindeki mesajı yazdır.
    3. butona tıklayın uyarıdaki metin kutusuna isminizi yazın OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini kontrol edin.
     */

    @Test
    public void test() {
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResp = result.getText();
        String expectedResp = "You successfully clicked an alert";
        Assert.assertTrue(actualResp.contains(expectedResp));
        Assert.assertEquals(expectedResp, actualResp);
    }

    @Test
    public void test2() {
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        System.out.println("Message in alert box : " + driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResp = result.getText();
        String expectedResp = "successfully";
        Assert.assertNotEquals(expectedResp, actualResp);

    }

    @Test
    public void test3() {
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Ali Can Yeni");
        driver.switchTo().alert().accept();
        WebElement result = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResp = result.getText();
        String expectedResp = "Ali Can Yeni";
        Assert.assertTrue(actualResp.contains(expectedResp));
    }
}
