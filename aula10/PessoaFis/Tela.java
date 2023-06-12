package aula10.PessoaFis;

//imports
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tela extends JFrame implements ActionListener {
    private JButton Adicionar;
    private JButton Limpar;

    private JLabel nome;
    private JLabel sobrenome;
    private JLabel cpf;


    private JTextField nomeTF;
    private JTextField sobrenomeTF;
    private JTextField cpfTF;


    // construtor
    public Tela() {
        // setar cabeçalho
        super("Sistema de pessoas");
        // criar botoes
        this.Adicionar = new JButton("Adicionar");
        this.Limpar = new JButton("Limpar");
        // criar campos de texto
        this.nome = new JLabel("Nome:");
        this.sobrenome = new JLabel("Sobrenome:");
        this.cpf = new JLabel("CPF:");

        this.nomeTF=new JTextField("",100);
        this.sobrenomeTF=new JTextField("",100);
        this.cpfTF=new JTextField("",100);
        // configuração do layout
        Container caixa = getContentPane();
        caixa.setLayout(new BorderLayout());
        JPanel painelCentro = new JPanel(new GridLayout(3, 2));
        JPanel painelSul = new JPanel(new FlowLayout());
        painelCentro.add(nome);
        painelCentro.add(nomeTF);
        painelCentro.add(sobrenome);
        painelCentro.add(sobrenomeTF);
        painelCentro.add(cpf);
        painelCentro.add(cpfTF);
        painelSul.add(Adicionar);
        painelSul.add(Limpar);	
        caixa.add(painelSul, BorderLayout.SOUTH);
        caixa.add(painelCentro, BorderLayout.CENTER);
        // configurar botões
        Adicionar.addActionListener(this);
        Limpar.addActionListener(this);
        // definir tamanho da janela
        setSize(400, 200);
        // botão de saída encerra o programa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Adicionar) {
            PessoaFisica Pessoa = new PessoaFisica(nomeTF.getText(), sobrenomeTF.getText(), cpfTF.getText());
            String pro = JOptionPane.showInputDialog("Qual a profissão: ");
            String mensagem = "";
            if (pro.equals("Desempregado")){
                Desempregado desempregado = new Desempregado();
                mensagem = desempregado.Dados();
                JOptionPane.showMessageDialog(null, mensagem);
            }
            else if (pro.equals("Horista")){
                double salario =0;
                while (salario <= 0) {
                    salario = Double.parseDouble(JOptionPane.showInputDialog("Salário:"));
                }
                double horas = 0;
                while (horas <=0){
                    horas = Double.parseDouble(JOptionPane.showInputDialog("Horas:"));
                }
                Horista horista = new Horista(nomeTF.getText(), sobrenomeTF.getText(), cpfTF.getText(), salario, horas);
                mensagem = horista.Dados();
                JOptionPane.showMessageDialog(null, mensagem);

            }
            else if (pro.equals("Tarefeiro")) {
                double salario = 0;
                while (salario <= 0) {
                    salario = Double.parseDouble(JOptionPane.showInputDialog("Salário:"));
                }
                int tarefas = 0;
                while (tarefas <= 0) {
                    tarefas = Integer.parseInt(JOptionPane.showInputDialog("Tarefas:"));
                }
                Tarefeiro tarefeiro = new Tarefeiro(nomeTF.getText(), sobrenomeTF.getText(), cpfTF.getText(), salario, tarefas);
                mensagem =tarefeiro.Dados();
                JOptionPane.showMessageDialog(null, mensagem);
            }
            else if (pro.equals("Mensalista")) {
                double salario = 0;
                while (salario <= 0) {
                    salario = Double.parseDouble(JOptionPane.showInputDialog("Salário:"));
                }
                int meses = 0;
                while (meses <= 0) {
                    meses = Integer.parseInt(JOptionPane.showInputDialog("Meses:"));
                }
                Mensalista mensalista = new Mensalista(nomeTF.getText(), sobrenomeTF.getText(), cpfTF.getText(), salario,
                        meses);
                mensagem = mensalista.Dados();
                JOptionPane.showMessageDialog(null, mensagem);
            }
            else if (pro.equals("Vendedor")) {
                double salario = 0;
                while (salario <= 0) {
                    salario = Double.parseDouble(JOptionPane.showInputDialog("Salário:"));
                }
                double valor_vendas = 0;
                while (valor_vendas <= 0) {
                    valor_vendas = Double.parseDouble(JOptionPane.showInputDialog("Horas:"));
                }
                Vendedor vendedor = new Vendedor(nomeTF.getText(), sobrenomeTF.getText(), cpfTF.getText(), salario,
                        valor_vendas);
                mensagem = vendedor.Dados();
                JOptionPane.showMessageDialog(null, mensagem);
            }
            else{
                JOptionPane.showMessageDialog(null, "Profissão inválida");
            }
            

        }
        if (e.getSource() == Limpar) {
            nomeTF.setText("");
            sobrenomeTF.setText("");
            cpfTF.setText("");
        }
    }
}
