package es.uniovi.asw;


import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Chamadoria on 24/02/2016.
 * @author UO236953
 */
public class ReportWriter {
    private StringBuffer sb;

    public ReportWriter(){
        sb = new StringBuffer();
    }

    public void add(String register){
        sb.append(register+'\n');
    }

    public void clean(){
        sb=new StringBuffer();
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
    @Override
    public String toString(){
        return sb.toString();
    }
}
