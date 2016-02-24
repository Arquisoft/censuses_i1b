package es.uniovi.asw.parser;

import static org.junit.Assert.assertEquals;

import es.uniovi.asw.util.Voter;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by Chamadoira on 24/02/2016.
 * @author UO236953
 */
public class XSSFReaderTest {
    String file=".\\src\\test\\java\\es\\uniovi\\asw\\parser\\votersXSSFReaderTest.xlsx";

    @Test
    public void read() {
        Reader reader = Reader.getInstanceXlsx();
        try {
            List<Voter> voters= reader.read(file);

            Voter a = voters.get(0);
            assertEquals(a.toString(),"Name: Alberto, DNI: 1111H, e-mail: alberto@gmail.com, Poll Station Code: A");
            System.out.println("Alberto's pass: "+a.getPass());

            Voter b =voters.get(1);
            assertEquals(b.toString(),"Name: Fernando, DNI: 22222J, e-mail: fernando@outlook.com, Poll Station Code: B");
            System.out.println("Fernando's pass: "+b.getPass());
        }catch(IOException e){
            System.out.println("The file '"+file+"' was not found");
        }
    }


}