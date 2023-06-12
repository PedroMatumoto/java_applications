package aula6.ExAluno;

import javax.swing.JOptionPane;

public class testealuno {

    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Nome:");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade"));
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Peso"));
        char sexo = JOptionPane.showInputDialog("Sexo(M/F)").charAt(0);

        Aluno aluno = new Aluno(nome, idade, peso, sexo);

        String msg = "Nome: " + aluno.getNome() + "\nIdade: " + aluno.getIdade() + " anos" + "\nPeso: " + aluno.getPeso()
                + " kg";
        
        if(aluno.getFormando()){
            msg+="\nFormando: sim";
        }else{
            msg+="\nFormando: nao";
        }
        if(aluno.getSexo()=='M'){
            msg+="\nSexo: masculino";
        }else{
            msg+="\nSexo: feminino";
        }
        JOptionPane.showMessageDialog(null,msg);
        idade = Integer.parseInt(JOptionPane.showInputDialog("Idade"));
        peso = Double.parseDouble(JOptionPane.showInputDialog("Peso"));
        boolean formando = Boolean.parseBoolean(JOptionPane.showInputDialog("É formando? (true/false)"));
        aluno.setIdade(idade);
        aluno.setPeso(peso);
        aluno.setFormando(formando);
        msg = "Nome: " + aluno.getNome() + "\nIdade: " + aluno.getIdade() + " anos" + "\nPeso: " + aluno.getPeso()
                + " kg";

        if (aluno.getFormando()) {
            msg += "\nFormando: sim";
        } else {
            msg += "\nFormando: nao";
        }
        if (aluno.getSexo() == 'M') {
            msg += "\nSexo: masculino";
        } else {
            msg += "\nSexo: feminino";
        }
        JOptionPane.showMessageDialog(null, msg);
        
    }   

}

