package es.uniovi.asw.parser;

import es.uniovi.asw.util.Voter;

import java.io.IOException;
import java.util.List;

/**
 * Created by Chamadoira on 24/02/2016.
 * @author UO236953
 */
public abstract class Reader {


    public abstract List<Voter> read(String file) throws IOException;

    public static Reader getInstanceXlsx(){
        return new XSSFReader();
    }
}
