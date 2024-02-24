package aula13.examples.ex5;

import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;

public class Formatando_Datas {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(2013,Calendar.FEBRUARY, 28);
        Date d = c.getTime();
        System.out.println("Data atual sem formatação: " + d);
        DateFormat df = DateFormat.getDateInstance();
        System.out.println("Data atual com formatação: " + df.format(d));
        DateFormat hora = DateFormat.getTimeInstance();
        System.out.println("Hora atual com formatação: " + hora.format(d));

        DateFormat dtHora = DateFormat.getDateTimeInstance();
        System.out.println(dtHora.format(d));
    }
    
}