package aula1;
import java.net.SocketTimeoutException;

import javax.swing.*;

public class ex1_modeswing {

    public static void main(String args[]) {
        String word1=JOptionPane.showInputDialog("Digite a palavra 1:");
        String word2 = JOptionPane.showInputDialog("Digite a palavra 2:");
        String word3 = JOptionPane.showInputDialog("Digite a palavra 3:");
        System.out.println(word1+" "+ word2+ " "+word3);
        JOptionPane.showMessageDialog(null, word1 + " " + word2 + " " + word3 );
        }

    }


