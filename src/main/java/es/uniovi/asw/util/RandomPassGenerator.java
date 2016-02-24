package es.uniovi.asw.util;

import java.security.SecureRandom;

/**
 * Created by Chamadoira on 17/02/2016.
 * @author UO236953
 */
public final class RandomPassGenerator {

    private final static int DEFAULT_PASS_LENGTH=10;

    private RandomPassGenerator(){}

    static String lower = "qwertyuiopasdfghjklzxcvbnm";
    static String upper = "QWERTYUIOPASDFGHJKLZXCVBNM";
    static String digits = "0123456789";

    public static String getRandomPass(){
        return getRandomPass(DEFAULT_PASS_LENGTH);
    }

    public static String getRandomPass(int length){
        SecureRandom r = new SecureRandom();
        StringBuilder pass = new StringBuilder();
        String set = lower+upper+digits; // characters to choose from

        for (int i= 0; i < length; i++) {
            pass.append(set.charAt(r.nextInt(set.length()-1)));
        }
        return pass.toString();
    }
}
