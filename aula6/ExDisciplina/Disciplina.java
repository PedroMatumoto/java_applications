package aula6.ExDisciplina;

import javax.swing.JOptionPane;

public class Disciplina {
    private String professor;
    private int semestre;
    private boolean ofertado;

    public Disciplina(String sensei, int semester, boolean offered) {
        this.professor = sensei;
        this.semestre = semester;
        this.ofertado= offered;
    }

    public String getProfessor() {
        return professor;
    }

    public int getSemestre() {
        return semestre;
    }

    public boolean getOfertado() {
        return ofertado;
    }

    // Modificadores

    public void setProfessor(String sensei) {
        professor=sensei;
    }

    public void setSemestre(int semester) {
        semestre=semester;
    }

    public void setOfertado(boolean offered) {
        ofertado=offered;
    }

}
