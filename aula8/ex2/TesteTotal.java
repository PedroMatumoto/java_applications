package aula8.ex2;

import java.beans.DesignMode;

import javax.management.InstanceNotFoundException;
import javax.swing.JOptionPane;


public class TesteTotal {
    public static void main(String[] args) {

        double salario =0;
        String nome=JOptionPane.showInputDialog("Nome:");
        String sobrenome=JOptionPane.showInputDialog("Sobrenome:");
        String cpf = JOptionPane.showInputDialog("CPF:");
        
        PessoaFisica PF = new PessoaFisica(nome, sobrenome, cpf);
        String mensagem = PF.Dados();
        JOptionPane.showMessageDialog(null, mensagem);

        Desempregado desempregado=new Desempregado();
        mensagem=desempregado.Dados();
        JOptionPane.showMessageDialog(null, mensagem);


        while(salario <=0){
        salario = Double.parseDouble(JOptionPane.showInputDialog("Salário:"));
        }
        Empregado empregado = new Empregado(nome, sobrenome, cpf, salario);
        mensagem = empregado.Dados();
        JOptionPane.showMessageDialog(null, mensagem);
        

        Mensalista mensalista=new Mensalista(nome,sobrenome,cpf,salario,6);
        mensagem=mensalista.Dados();
        JOptionPane.showMessageDialog(null, mensagem);

        Tarefeiro tarefeiro = new Tarefeiro(nome, sobrenome, cpf, salario, 6);
        mensagem = tarefeiro.Dados();
        JOptionPane.showMessageDialog(null, mensagem);

        Horista horista = new Horista(nome, sobrenome, cpf, salario, 6);
        mensagem = horista.Dados();
        JOptionPane.showMessageDialog(null, mensagem);

        double v_vendas= Double.parseDouble(JOptionPane.showInputDialog("Valor vendido:"));
        Vendedor vendedor = new Vendedor(nome, sobrenome, cpf, salario, v_vendas);
        mensagem =vendedor.Dados();
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
}
