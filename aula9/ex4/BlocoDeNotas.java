package aula9.ex4;

import java.util.ArrayList;

public class BlocoDeNotas {

    ArrayList<String> notas = new ArrayList<String>();

    public void addNota(String nota) {
        notas.add(nota);
    }

    public void removeNota(int index) {
        notas.remove(index);
    }

    public void editNota(int index, String nota) {
        notas.set(index, nota);
    }

    public void printNotas() {
        for (int i = 0; i < notas.size(); i++) {
            System.out.println("Nota " + i + ": ");
            System.out.println(notas.get(i));
        }
    }
    
}
