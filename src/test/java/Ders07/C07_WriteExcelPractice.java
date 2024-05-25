package Ders07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C07_WriteExcelPractice {

    //-Dosya yolunu bir String degiskene atayalim
    //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    //5.hucreye yeni bir cell olusturalim
    //Olusturdugumuz hucreye “PUAN” yazdiralim
    //2.satir PUAN kolonuna 85 yazdiralim
    //10.satir PUAN kolonuna 72 yazdiralim
    //5.satir PUAN kolonuna 72 yazdiralim
    //Dosyayi kaydedelim
    //Dosyayi kapatalim
    @Test
    public void test() throws IOException {

        String excel = "src/resources/takimlar.xlsx";
        FileInputStream fileInputStream = new FileInputStream(excel);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        workbook.getSheet("sayfa1").getRow(0).createCell(4).setCellValue("PUAN");

        workbook.getSheet("sayfa1").getRow(1).createCell(4).setCellValue("85");

        workbook.getSheet("sayfa1").getRow(9).createCell(4).setCellValue("72");

        workbook.getSheet("sayfa1").getRow(9).createCell(4).setCellValue("yeni olusturuldu");

        FileOutputStream fileOutputStream = new FileOutputStream(excel);
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();

    }
}
