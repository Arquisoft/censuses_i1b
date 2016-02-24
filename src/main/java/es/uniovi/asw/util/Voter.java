package es.uniovi.asw.util;

/**
 * Created by Chamadoira on 17/02/2016.
 * @author UO236953
 */
public class Voter {
    private String name, dni, email, stationCode, pass;

    public Voter(String name, String dni, String email, String stationCode, String pass) {
        this.name = name;
        this.dni = dni;
        this.email = email;
        this.stationCode = stationCode;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public String getStationCode() {
        return stationCode;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public String toString(){
        return "Name: "+getName()+", DNI: "+getDni()+", e-mail: "+getEmail()+", Poll Station Code: "+getStationCode();
    }
}
