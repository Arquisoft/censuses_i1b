package es.uniovi.asw;

import es.uniovi.asw.jdbc.InsertDBTest;
import es.uniovi.asw.parser.XSSFReaderTest;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Chamadoira on 24/02/2016.
 * @author UO236953
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ XSSFReaderTest.class, ReportWriterTest.class, InsertDBTest.class} )
public final class AllTestSuite {}