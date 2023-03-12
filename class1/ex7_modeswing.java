

package aula1;

import java.util.Scanner;

import javax.swing.*;

import javax.sound.sampled.SourceDataLine;

public class ex7_modeswing {

    public static void main(String args[]) {
        String c;
        String palavra_ant = "";
        Scanner read = new Scanner(System.in);
        for (int i = 0; i <= 3; i++) {
            c = JOptionPane.showInputDialog("Digite o numero:");
            palavra_ant+=c;

        }
        JOptionPane.showMessageDialog(null, palavra_ant);

    }

}