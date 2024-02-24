package aula13.examples.ex7;

import java.util.Calendar;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class Conversao_Datas {
    public static void main(String[] args) throws ParseException {
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        DateFormat f = DateFormat.getDateInstance();
        System.out.println("Data atual: " + f.format(data));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Data atual: " + sdf.format(data));
        System.out.println("Data atual: " + sdf.parse("21/03/1963"));
    }
    
}
