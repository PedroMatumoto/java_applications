package aula7.ex1;

import javax.swing.JOptionPane;

public class Atribuicao {
    private Professor professor;
    private Disciplina disciplina;

    public Atribuicao(Professor professor, Disciplina disciplina) {
        this.professor = professor;
        this.disciplina = disciplina;
    }


    // Modificadores

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public String getDados() {
        return "" + professor.getProfessor()+" " + disciplina.getDisciplina();
    }

}
