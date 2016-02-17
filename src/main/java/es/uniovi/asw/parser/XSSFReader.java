package es.uniovi.asw.parser;

import es.uniovi.asw.util.RandomPassGenerator;
import es.uniovi.asw.util.Voter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Chamadoira on 17/02/2016.
 * @author UO236953
 */
public final class XSSFReader {

    private XSSFReader(){}

    public static List<Voter> read(String file) throws IOException {
        List<Voter> voters = new ArrayList<Voter>();
        XSSFSheet spreadsheet = new XSSFWorkbook(new FileInputStream(new File(file))).getSheetAt(0);
        Iterator<Row> rowIterator = spreadsheet.iterator();
        Row row = rowIterator.next();
        while (rowIterator.hasNext()){
            voters.add(new Voter(
                    row.getCell(0).getStringCellValue(),
                    row.getCell(1).getStringCellValue(),
                    row.getCell(2).getStringCellValue(),
                    (int) row.getCell(3).getNumericCellValue(),
                    RandomPassGenerator.getRandomPass()));
        }
        return voters;
    }
}
