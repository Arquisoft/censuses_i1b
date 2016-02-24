package es.uniovi.asw.jdbc;

import es.uniovi.asw.jdbc.Jdbc;
import es.uniovi.asw.util.Voter;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by uo237633 on 21/02/2016.
 */
public final class InsertDB {

    private InsertDB(){
    }

    public static void insert(List<Voter> voters) throws FileNotFoundException, UnsupportedEncodingException {
        String s = "Insert into voters values(?,?,?,?,?)";
        String q = "Select * from voters where NIF = ?";

        Connection c = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;

        int row = 0;

        try {
            c = Jdbc.getConnection();
            ps = c.prepareStatement(s);
            String filename  = "";
            for (Voter v : voters) {
                row++;
                ps2 = c.prepareStatement(q);

                ps2.setString(1, v.getDni());

                rs = ps2.executeQuery();

                if (!rs.isBeforeFirst()) {
                    ps.setString(1, v.getDni());
                    ps.setString(2, v.getName());
                    ps.setString(3, v.getEmail());
                    ps.setString(4, v.getStationCode());
                    ps.setString(5, v.getPass());

                    ps.executeUpdate();

                    filename = v.getDni();

                    PrintWriter writer = new PrintWriter(filename + ".txt", "UTF-8");
                    writer.println("Dear " + v.getName() + ", here's your voting information");
                    writer.println("Voting Station: " + v.getStationCode());
                    writer.println("Password: " + v.getPass());
                    writer.close();
                } else {
                    System.out.println("The voter " + v.getDni() + " has already been added");

                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(c != null)
                Jdbc.close(c);
            if(ps != null)
                Jdbc.close(ps);
        }
    }
}
