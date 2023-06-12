package aula3;

import javax.swing.JOptionPane;

public class ex20 {

    public static void main(String[] args) {
        String S_ca = JOptionPane.showInputDialog("Lado 1: ");
        double ca = Double.parseDouble(S_ca);

        String S_co = JOptionPane.showInputDialog("Lado 2: ");
        double co = Double.parseDouble(S_co);

        String S_ang = JOptionPane.showInputDialog("Angulo: ");
        double ang = Double.parseDouble(S_ang);

        double ang_rad= Math.toRadians(ang);
        

        double terc_l = Math.sqrt(co*co+ca*ca-2*co*ca*Math.cos(ang_rad));
        
        JOptionPane.showMessageDialog(null, "Terceiro lado: " + terc_l);

    }

}
