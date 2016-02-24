package es.uniovi.asw;

import es.uniovi.asw.jdbc.InsertDB;
import es.uniovi.asw.parser.Reader;
import es.uniovi.asw.util.Voter;

import java.io.IOException;
import java.util.List;

/**
 * Main application
 * @author UO236953
 * @author Labra
 *
 */
public class LoadUsers {

	public static void main(String... args) {
		Reader lector = Reader.getInstanceXlsx();
		try {
			List<Voter> voters= lector.read(args[0]);
			for(Voter v : voters){
				System.out.println(v.toString());
			}
			InsertDB.insert(voters);
		}catch(IOException e){
			System.out.println("The file '"+args[0]+"' was not found");
		}
	}
}
