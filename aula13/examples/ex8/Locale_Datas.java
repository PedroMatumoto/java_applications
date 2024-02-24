package aula13.examples.ex8;

import java.util.*;
import java.text.*;

public class Locale_Datas {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        Locale brasil = new Locale("pt", "BR");
        Locale eua = Locale.US;
        Locale italia = Locale.ITALY;
        DateFormat fb = DateFormat.getDateInstance(DateFormat.FULL, brasil);
        System.out.println("Data brasileira: " + fb.format(data));
        DateFormat fe = DateFormat.getDateInstance(DateFormat.SHORT, brasil);
        System.out.println("Data brasileira: " + fe.format(data));
        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL, eua);
        System.out.println("Data americana: " + f.format(data));
        DateFormat a = DateFormat.getDateInstance(DateFormat.SHORT, eua);
        f = DateFormat.getDateInstance(DateFormat.FULL, italia);
        System.out.println("Data italiana: " + f.format(data));
        DateFormat i = DateFormat.getDateInstance(DateFormat.SHORT, italia);
        System.out.println("Data italiana: " + i.format(data));
    }
    
}
