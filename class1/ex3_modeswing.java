package aula1;
import java.net.SocketTimeoutException;

import javax.swing.*;

public class ex3_modeswing {

    public static void main(String args[]) {
        String num = JOptionPane.showInputDialog("Digite o número:");
        Integer.parseInt(num);
        System.out.println("O número digitado é "+ num);
        JOptionPane.showMessageDialog(null, "O número digitado é " + num);
        }
    }


