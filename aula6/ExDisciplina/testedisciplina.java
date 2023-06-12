package aula6.ExDisciplina;

import javax.swing.JOptionPane;

public class testedisciplina {

    public static void main(String[] args) {
        String professor = JOptionPane.showInputDialog("Professor:");
        int semestre = Integer.parseInt(JOptionPane.showInputDialog("Semestre"));
        char ofertado=JOptionPane.showInputDialog("Ofertado? (S/N):").charAt(0);
        boolean of=false;

        if(ofertado=='S'){
            of=true;
        }
        if (ofertado == 'N') {
            of = false;
        }

        Disciplina disciplina = new Disciplina(professor, semestre,of);

        String msg = "Professor: " + disciplina.getProfessor() + "\nSemestre: " + disciplina.getSemestre();
        

        if (disciplina.getOfertado()) {
            msg += "\nOfertado: sim";
        } else {
            msg += "\nFormando: nao";
        }

        JOptionPane.showMessageDialog(null, msg);

    }

}
