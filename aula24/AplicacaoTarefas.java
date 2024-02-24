import Model.*;
import Controller.*;
import View.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import Controller.*;


public class AplicacaoTarefas extends JFrame implements ActionListener{
    private JButton btnAdicionar;
    private JButton btnRemover;
    private JButton btnMarcar;
    private JButton btnDesmarcar;
    private JButton btnMostrar;
    private JTextField txtDescricao;

    private JLabel lblDescricao;

    private TarefaController controller;

    private JLabel lista;

    public AplicacaoTarefas(){
        super("Lista de Tarefas");
        this.btnAdicionar = new JButton("Adicionar");
        this.btnRemover = new JButton("Remover");
        this.btnMarcar = new JButton("Marcar");
        this.btnDesmarcar = new JButton("Desmarcar");
        this.btnMostrar = new JButton("Mostrar");

        this.txtDescricao = new JTextField(20);

        this.lblDescricao = new JLabel("Descrição:");

        this.lista= new JLabel("Lista de Tarefas");

        this.controller = new TarefaController();

        Container caixa = getContentPane();
        caixa.setLayout(new BorderLayout());

        JPanel pnlBotoes = new JPanel(new FlowLayout());
        pnlBotoes.add(btnAdicionar);
        pnlBotoes.add(btnRemover);
        pnlBotoes.add(btnMarcar);
        pnlBotoes.add(btnDesmarcar);
        pnlBotoes.add(btnMostrar);

        JPanel pnlDescricao = new JPanel(new FlowLayout());
        pnlDescricao.add(lblDescricao);
        pnlDescricao.add(txtDescricao);


        JPanel pnlLista = new JPanel(new FlowLayout());
        pnlLista.add(lista);

        caixa.add(pnlDescricao, BorderLayout.NORTH);
        caixa.add(pnlBotoes, BorderLayout.SOUTH);
        caixa.add(pnlLista, BorderLayout.CENTER);

        btnAdicionar.addActionListener(this);
        btnRemover.addActionListener(this);
        btnMarcar.addActionListener(this);
        btnDesmarcar.addActionListener(this);
        btnMostrar.addActionListener(this);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

    
     
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAdicionar) {
            controller.adicionarTarefa(txtDescricao.getText());
            txtDescricao.setText("");
        } else if(e.getSource() == btnRemover) {
            controller.removerTarefa(0);
        } else if(e.getSource() == btnMarcar) {
            controller.marcarTarefaComoConcluida(0);
        } else if(e.getSource() == btnDesmarcar) {
            controller.desmarcarTarefaComoConcluida(0);
        } else if(e.getSource() == btnMostrar) {
            lista.setText(controller.atualizarView());
        }
    }

    
}
