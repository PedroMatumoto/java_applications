import javax.swing.JOptionPane;

public class ex27 {
    public static void main(String[] args) {
        String palavra=JOptionPane.showInputDialog("Digite um verbo no infinitivo: ");
        char letras[]=palavra.toCharArray();
        int tam= letras.length;

        System.out.println(tam);

        System.out.println(letras);

        if (!((letras[tam - 1]) == 'r')) {
            JOptionPane.showMessageDialog(null, "Não é verbo");
        }

        if((letras[tam-1]) == 'r' && (letras[tam-2])=='o'){
            JOptionPane.showMessageDialog(null, "Não é verbo no infinitivo");
        }

        if ((letras[tam - 1]) == 'r' && (letras[tam - 2]) == 'u') {
            JOptionPane.showMessageDialog(null, "Não é verbo no infinitivo");
        }


        if((letras[tam-1]) == 'r' && (letras[tam-2])=='a'){
            JOptionPane.showMessageDialog(null, "Primeira conjugação");
        }
        if ((letras[tam - 1]) == 'r' && (letras[tam - 2]) == 'e') {
            JOptionPane.showMessageDialog(null, "Segunda conjugação");
        }
        if ((letras[tam - 1]) == 'r' && (letras[tam - 2]) == 'i') {
            JOptionPane.showMessageDialog(null, "Terceira conjugação");
        }
    }
    
}
