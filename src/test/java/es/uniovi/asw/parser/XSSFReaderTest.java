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
            assertEquals(a.getName(),"Alberto");
            assertEquals(a.getDni(),"1111H");
            assertEquals(a.getEmail(),"alberto@gmail.com");
            assertEquals(a.getStationCode(),"A");
            System.out.println(a);

            Voter b =voters.get(1);
            assertEquals(b.getName(),"Fernando");
            assertEquals(b.getDni(),"22222J");
            assertEquals(b.getEmail(),"fernando@outlook.com");
            assertEquals(b.getStationCode(),"B");
            System.out.println(b);
        }catch(IOException e){
            System.out.println("The file '"+file+"' was not found");
        }
    }


}