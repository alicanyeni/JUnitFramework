package Ders06;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileExist {

    @Test
    public void test() {
        System.out.println(System.getProperty("user.dir"));

        String anaDizin = System.getProperty("user.home");

        System.out.println(anaDizin);

        //String file="\\Users\\alicanyeni\\Desktop\\testText";
        String file = "/Users/alicanyeni/Desktop/testText";
        Assert.assertTrue(Files.exists(Paths.get(file)));
    }
}
