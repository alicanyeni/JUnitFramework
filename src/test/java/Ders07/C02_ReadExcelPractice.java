package Ders07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcelPractice {

    //- Dosya yolunu bir String degiskene atayalim
    //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    // - Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    //- Sheet objesi olusturun
    //- Row objesi olusturun
    //- Cell objesi olusturun


    @Test
    public void readExcel() throws IOException {
        String excel = "src/resources/takimlar.xlsx";

        FileInputStream fis = new FileInputStream(excel);

        Workbook workbook = WorkbookFactory.create(fis);

        String actualData = workbook.getSheet("Sayfa1").getRow(4).getCell(1).toString();
        System.out.println(actualData);
    }
}
