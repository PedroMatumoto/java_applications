package aula3;

import javax.swing.JOptionPane;

public class ex8 {
    public static void main(String[] args) {
        String angulo=JOptionPane.showInputDialog("Digite o angulo:");
        double graus= Double.parseDouble(angulo);
        double a_num= Math.toRadians(graus);
        

        JOptionPane.showMessageDialog(null, "Seno:" + Math.sin(a_num)+ "\n"+ "Cosseno:" +Math.cos(a_num)+ "\n"+ "Tangente:" +Math.tan(a_num)+ "\n"+ "Secante:" +1/Math.cos(a_num)+"\n"+ "Cossecante:" + 1/Math.sin(a_num)+ "\n"+"Cotagente:"+1/Math.tan(a_num));
        }
    
}
