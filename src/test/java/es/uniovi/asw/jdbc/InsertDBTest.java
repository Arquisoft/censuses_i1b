package es.uniovi.asw.jdbc;

import es.uniovi.asw.parser.Reader;
import es.uniovi.asw.util.Voter;
import org.junit.Test;
import org.junit.runner.Result;

import java.io.IOException;
import java.sql.*;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by uo237633 on 24/02/2016.
 * @author uo237633
 */
public class InsertDBTest {
    String file=".\\src\\test\\java\\es\\uniovi\\asw\\jdbc\\votersXSSFReaderTest.xlsx";
    //String file="./src/test/java/es/uniovi/asw/jdbc/votersXSSFReaderTest.xlsx";
    @Test
    public void read() {
        Reader reader = Reader.getInstanceXlsx();
        try {
            List<Voter> voters= reader.read(file);

            InsertDB.insert(voters);

            String s = "Select * from voters where Name = 'Alberto'";

            try {
                Connection c = Jdbc.getConnection();

                PreparedStatement st = c.prepareStatement(s);

                ResultSet rs = st.executeQuery();

                Voter v = null;

                while(rs.next()){

                    v = new Voter(rs.getString(2), rs.getString(1), rs.getString(3), rs.getString(4), rs.getString(5));
                }

                Voter v2 = voters.get(0);

                assertEquals(v2.getDni(), v.getDni());
                assertEquals(v2.getName(), v.getName());
                assertEquals(v2.getEmail(), v.getEmail());
                assertEquals(v2.getStationCode(), v.getStationCode());

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }catch(IOException e){
            System.out.println("The file '"+file+"' was not found");
        }
    }


}