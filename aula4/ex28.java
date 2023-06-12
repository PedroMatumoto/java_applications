
import javax.swing.JOptionPane;

public class ex28 {
    public static void main(String[] args) {
        //- alunos cujo nome começa com as letras de A a K estão na D1;
        //- alunos cujo nome começa com as letras de L a N estão na D2;
        //- alunos cujo nome começa com as letras de O a Z estão na D3.

        String nome = JOptionPane.showInputDialog("Nome:");
        char[] palavra = nome.toCharArray();
        int letraini = palavra[0];

        System.out.println(letraini);

        if (letraini <= (0 + 65) || letraini <= (10 + 65)) {
            JOptionPane.showMessageDialog(null, "D1");
        }

        else if (letraini > (11 + 65) || letraini <= (14 + 65)) {
            JOptionPane.showMessageDialog(null, "D2");
        }

        else if (letraini > (15 + 65) || letraini <= (25 + 65)) {
            JOptionPane.showMessageDialog(null, "D3");
        }

    }
    
}
