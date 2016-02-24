package es.uniovi.asw;


import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Chamadoria on 24/02/2016.
 * @author UO236953
 */
public class ReportWritter {
    private StringBuffer sb;

    public ReportWritter(){
        sb = new StringBuffer();
    }

    public void add(String register){
        sb.append(register+'\n');
    }

    public void clean(){
        sb.delete(0,sb.length()-1);
    }
    public void print(){
        System.out.println(sb);
    }
    public void makeTxt(String fileName){
        try {
            PrintWriter writer = new PrintWriter(fileName + ".txt");
            writer.print(sb);
            writer.close();
        }catch (FileNotFoundException e1) {
                e1.printStackTrace();
        }
    }
}
