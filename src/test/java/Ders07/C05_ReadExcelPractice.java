package Ders07;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C05_ReadExcelPractice {
    //-Dosya yolunu bir String degiskene atayalim
    //-FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
    //-Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
    //-sayfa 2'ye gidip satir sayisinin 17, kullanilan satir sayisinin ise 5 oldugunu test edin


    @Test
    public void test() throws IOException {

        String excel = "src/resources/takimlar.xlsx";
        FileInputStream fis = new FileInputStream(excel);
        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatir = workbook.getSheet("sayfa2").getLastRowNum();
        System.out.println(sonSatir);
        int expectedRow = 17;
        Assert.assertEquals(expectedRow, sonSatir + 1);

        int kullanilanSatirSayisi = workbook.getSheet("sayfa2").getPhysicalNumberOfRows();
        System.out.println(kullanilanSatirSayisi);
        int expectedkullanilanSatirSayisi=5;
        Assert.assertEquals(expectedkullanilanSatirSayisi,kullanilanSatirSayisi);
    }
}
