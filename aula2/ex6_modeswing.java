package aula2;

import javax.swing.*;

import java.util.Scanner;

public class ex6_modeswing {

    public static void main(String args[]) {
        String palavra_ant = "";
        for (int i = 0; i < 10; i++) {
            String c = JOptionPane.showInputDialog("Digite o caractere:");
            palavra_ant=palavra_ant+c;
        }
        JOptionPane.showMessageDialog(null, palavra_ant);
    } 
    
}
