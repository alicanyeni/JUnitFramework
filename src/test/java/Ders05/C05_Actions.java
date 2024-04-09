package Ders05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class C05_Actions extends TestBaseBeforeAfter {

    //https://demoqa.com/droppable adresine gidelim
    //“Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    //“Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test() {
        driver.get("https://demoqa.com/droppable");
        WebElement dragMe = driver.findElement(By.cssSelector("#draggable"));
        WebElement dropHere = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe, dropHere).perform();

        Assert.assertEquals("Dropped!", driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]")).getText());
    }
}
