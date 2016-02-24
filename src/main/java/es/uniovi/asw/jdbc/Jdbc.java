package es.uniovi.asw.jdbc;

import java.sql.*;

/**
 * Clase de utilidad para el acceso a la base de datos
 * Created by Chamadoira on 15/02/2016.
 *
 * @author UO236953
 */
public class Jdbc {
    private static String DRIVER = "org.sqlite.JDBC";
    private static String URL = "jdbc:sqlite:voters.db";
    private static String USER = "sa";
    private static String PASS = "";

    static {
        try {
            Class.forName( DRIVER );
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver not found in classpath", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public static void close(ResultSet rs, Statement st, Connection c) {
        close(rs);
        close(st);
        close(c);
    }

    public static void close(ResultSet rs, Statement st) {
        close(rs);
        close(st);
    }

    protected static void close(ResultSet rs) {
        if (rs != null) try { rs.close(); } catch(SQLException e) {}
    }

    public static void close(Statement st) {
        if (st != null ) try { st.close(); } catch(SQLException e) {}
    }

    public static void close(Connection c) {
        if (c != null) try { c.close(); } catch(SQLException e) {}
    }

    public static Connection createThreadConnection() throws SQLException {
        Connection con = getConnection();
        con.setAutoCommit( false );
        threadConnection.set(con);
        return con;
    }

    private static ThreadLocal<Connection> threadConnection = new ThreadLocal<Connection>();

    public static Connection getCurrentConnection() {
        return threadConnection.get();
    }
}
