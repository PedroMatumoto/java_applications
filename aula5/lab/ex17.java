package aula5.lab;

import javax.swing.JOptionPane;

public class ex17 {
    public static void main(String[] args) {
        String inf = JOptionPane.showInputDialog("Limite inferior em Fahrenheit: ");
        String sup = JOptionPane.showInputDialog("Limite superior em Fahrenheit: ");
        String inc = JOptionPane.showInputDialog("Passo: ");
        int inferior = Integer.parseInt(inf);
        int superior = Integer.parseInt(sup);
        int incremento = Integer.parseInt(inc);
        System.out.println("Fahrenheit:\tCelsius:");
        for (int i=inferior;i<superior+incremento;i+=incremento){
            System.out.println(i+ "\t\t"+(5*(i-32)/9) );
        }
        

        

    }
    
}
