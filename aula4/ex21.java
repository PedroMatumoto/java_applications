

import javax.swing.JOptionPane;

public class ex21 {
    public static void main(String[] args) {
        String valor1 = JOptionPane.showInputDialog("Primeiro valor:");
        int v1 = Integer.parseInt(valor1);
        String valor2 = JOptionPane.showInputDialog("Segundo valor:");
        int v2 = Integer.parseInt(valor2);
        String valor3 = JOptionPane.showInputDialog("Terceiro valor:");
        int v3 = Integer.parseInt(valor3);
        int[] numeros = { v1, v2, v3 };

        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = 0; j < numeros.length - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int aux = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = aux;
                }
            }
        }

        JOptionPane.showMessageDialog(null, (numeros[numeros.length - 1]));

    }

}
