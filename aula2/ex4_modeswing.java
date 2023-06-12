package aula2;

import java.net.SocketTimeoutException;

import javax.swing.*;

public class ex4_modeswing {

    public static void main(String args[]) {
        String dia = JOptionPane.showInputDialog("Digite o dia:");
        String mes = JOptionPane.showInputDialog("Digite o mês:");
        String ano = JOptionPane.showInputDialog("Digite o ano:");
        JOptionPane.showMessageDialog(null, dia + "/" + mes + "/" + ano);
    } 

}
