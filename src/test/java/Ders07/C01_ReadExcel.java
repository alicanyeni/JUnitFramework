package Ders07;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    //- Dosya yolunu bir String degiskene atayalim
    //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    // - Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    //- Sheet objesi olusturun
    //- Row objesi olusturun
    //- Cell objesi olusturun
    //- 3. index'deki satirin 2. index'indeki datanin Norvec oldugunu test edin

    @Test
    public void readExcelTest() throws IOException {
        String excel = "src/resources/takimlar.xlsx";

        FileInputStream fis = new FileInputStream(excel);

        Workbook workbook = WorkbookFactory.create(fis);

        Sheet sheet = workbook.getSheet("Sayfa1");

        Row row = sheet.getRow(3);

        Cell cell = row.getCell(2);

        String expectedData = "Norvec";
        String actualData = cell.toString();

        Assert.assertEquals(expectedData, actualData);

        System.out.println(actualData);

    }
}
