package aula1;
import java.net.SocketTimeoutException;

import javax.swing.*;

public class ex2_modeswing {

    public static void main(String args[]) {
        String word1 = JOptionPane.showInputDialog("Digite a palavra 1:");
        String word2 = JOptionPane.showInputDialog("Digite a palavra 2:");
        String word3 = JOptionPane.showInputDialog("Digite a palavra 3:");
        JOptionPane.showMessageDialog(null, word3 + " " + word2 + " " + word1);
        }

    }


