package Ders07;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C08_DeleteExcelPractice {
    //- Dosya yolunu bir String degiskene atayalim
    //- FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    // - Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    //- Sheet objesi olusturun
    //- Row objesi olusturun
    //- Cell objesi olusturun
    //-3. Satır 3. Cell'deki veriyi silelim


    @Test
    public void test() throws IOException {
        String excel = "src/resources/takimlar.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excel);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheet("sayfa1");

        Row row = sheet.getRow(1);

        Cell cell = row.getCell(2);

        row.removeCell(cell);

        FileOutputStream fileOutputStream = new FileOutputStream(excel); //kaydetmek için


    }
}
