package es.uniovi.asw;

import es.uniovi.asw.util.RandomPassGenerator;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;
/**
 * Created by Chamadoira on 24/02/2016.
 * @author UO236953
 */
public class ReportWriterTest {
    String file=".\\src\\test\\java\\es\\uniovi\\asw\\ReportWriterTest.txt";

    @Test
    public void textGeneratorTest(){
        ReportWriter rw = new ReportWriter();
        rw.add("Message 1");
        rw.add("Message 2");
        rw.add("Message 3");
        assertEquals(rw.toString(),"Message 1\nMessage 2\nMessage 3\n");
        rw.clean();
        assertEquals(rw.toString(),"");
    }
    @Test
    public void txtWriter(){
        ReportWriter rw = new ReportWriter();
        rw.add("Message 1");
        rw.add("Message 2");
        rw.add("Message 3");

        String randomNameFile =RandomPassGenerator.getRandomPass();
        rw.makeTxt(randomNameFile);
        try {
            BufferedReader fileCreated = new BufferedReader(new FileReader(randomNameFile+".txt"));
            BufferedReader fileOriginal = new BufferedReader(new FileReader(file));
            assertEquals( fileCreated.readLine(),fileOriginal.readLine());

        } catch (java.io.IOException e) {
            e.printStackTrace();
        }


    }
}
