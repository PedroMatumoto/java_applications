package aula13.examples.ex6;

import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;

public class Formatando_Saida_datas {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("Data atual: " + f.format(data));
        f = DateFormat.getDateInstance(DateFormat.LONG);
        System.out.println("Data atual sem dia: " + f.format(data));
        f = DateFormat.getDateInstance(DateFormat.MEDIUM);
        System.out.println("Data atual resumida: " + f.format(data));
        f = DateFormat.getDateInstance(DateFormat.SHORT);
        System.out.println("Data atual resumida plus: " + f.format(data));
    }
    
}
