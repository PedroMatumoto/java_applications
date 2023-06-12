package aula9.ex1;

import javax.swing.JOptionPane;

public class Teste {
    public static void main(String[] args) {
        String nome = JOptionPane.showInputDialog("Nome: ");
        int idade=0;
        while(idade<=0||idade>110){
            idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
        }
        Pessoa pessoa = new Pessoa(nome, idade);
        JOptionPane.showMessageDialog(null, pessoa.getDados());
        
        String cargo = JOptionPane.showInputDialog("Cargo: ");
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Salário: "));
        Funcionario funcionario = new Funcionario(nome, idade, salario,cargo);
        String opcao = JOptionPane.showInputDialog("Já é aposentado? (S/N)");
        if(opcao.equals("S")){
            FuncionarioAposentado FA = new FuncionarioAposentado(nome, idade, salario,cargo);
            JOptionPane.showMessageDialog(null, FA.getDados());
        }
        else if(opcao.equals("N")){
            JOptionPane.showMessageDialog(null, funcionario.getDados());
        }
        else{
            JOptionPane.showMessageDialog(null, "Opção inválida!");
        }
    }
    
}
