package aula5.lab;

import javax.swing.JOptionPane;

public class ex18 {
    public static void main(String[] args) {

        int num_f = 20;// operação para recuperar n_f (puxar 5 e declarar) 2

        double r_fat = 1;// operação para recuperar r_fat 2

        while (num_f > 0) {// (3*(n+1))
            r_fat = num_f * r_fat;// 4*n operações;
            num_f--;// (4*n)
        }

        System.out.println(r_fat);
        // 11n +7
    }
}
