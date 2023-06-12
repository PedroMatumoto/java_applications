package aula10.TrueCalc;

//imports
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaTrueCalc extends JFrame implements ActionListener {
    private JButton um;
    private JButton dois;
    private JButton tres;
    private JButton quatro;
    private JButton cinco;
    private JButton seis;
    private JButton sete;
    private JButton oito;
    private JButton nove;
    private JButton zero;
    private JButton soma;
    private JButton sub;
    private JButton div;
    private JButton multi;
    private JButton C;
    private JButton igual;
    private JTextField texto;
    private int valor_ant;
    private int operacao;
    private int valor_atual;
    private int resultado;

    // construtor
    public TelaTrueCalc() {
        super("Calculadora");
        this.um = new JButton("1");
        this.dois = new JButton("2");
        this.tres = new JButton("3");
        this.quatro = new JButton("4");
        this.cinco = new JButton("5");
        this.seis = new JButton("6");
        this.sete = new JButton("7");
        this.oito = new JButton("8");
        this.nove = new JButton("9");
        this.zero = new JButton("0");
        this.soma = new JButton("+");
        this.sub = new JButton("-");
        this.multi = new JButton("x");
        this.div = new JButton("/");
        this.C = new JButton("C");
        this.igual = new JButton("=");
        this.texto = new JTextField("", 10);

        // painelCima.setLayout(new BorderLayout());
        // painelCima.add(etiqueta, BorderLayout.WEST);
        Container caixa = getContentPane();
        caixa.setLayout(new BorderLayout());
        JPanel painelCima = new JPanel(new FlowLayout());
        JPanel painelCenter =new JPanel(new GridLayout(4,4));
        painelCenter.add(sete);
        painelCenter.add(oito);
        painelCenter.add(nove);
        painelCenter.add(soma);
        painelCenter.add(quatro);
        painelCenter.add(cinco);
        painelCenter.add(seis);
        painelCenter.add(sub);
        painelCenter.add(um);
        painelCenter.add(dois);
        painelCenter.add(tres);
        painelCenter.add(multi);
        painelCenter.add(zero);
        painelCenter.add(C);
        painelCenter.add(igual);
        painelCenter.add(div);
        painelCima.add(texto);
        caixa.add(painelCima, BorderLayout.CENTER);
        caixa.add(painelCenter, BorderLayout.SOUTH);

        um.addActionListener(this);
        dois.addActionListener(this);
        tres.addActionListener(this);
        quatro.addActionListener(this);
        cinco.addActionListener(this);
        seis.addActionListener(this);
        sete.addActionListener(this);
        oito.addActionListener(this);
        nove.addActionListener(this);
        zero.addActionListener(this);
        soma.addActionListener(this);
        sub.addActionListener(this);
        multi.addActionListener(this);
        div.addActionListener(this);
        C.addActionListener(this);
        igual.addActionListener(this);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == um) {
            texto.setText(texto.getText() + "1");
        }
        if (e.getSource() == dois) {
            texto.setText(texto.getText() + "2");
        }
        if (e.getSource() == tres) {
            texto.setText(texto.getText() + "3");
        }
        if (e.getSource() == quatro) {
            texto.setText(texto.getText() + "4");
        }
        if (e.getSource() == cinco) {
            texto.setText(texto.getText() + "5");
        }
        if (e.getSource() == seis) {
            texto.setText(texto.getText() + "6");
        }
        if (e.getSource() == sete) {
            texto.setText(texto.getText() + "7");
        }
        if (e.getSource() == oito) {
            texto.setText(texto.getText() + "8");
        }
        if (e.getSource() == nove) {
            texto.setText(texto.getText() + "9");
        }
        if (e.getSource() == zero) {
            texto.setText(texto.getText() + "0");
        }
        if (e.getSource() == soma) {
            operacao = 1;
            valor_ant=Integer.parseInt(texto.getText());
            texto.setText("");
        }
        if (e.getSource() == sub) {
            operacao = 2;
            valor_ant = Integer.parseInt(texto.getText());
            texto.setText("");
        }
        if (e.getSource() == multi) {
            operacao = 3;
            valor_ant = Integer.parseInt(texto.getText());
            texto.setText("");
        }
        if (e.getSource() == div) {
            operacao = 4;
            valor_ant = Integer.parseInt(texto.getText());
            texto.setText("");
        }
        if (e.getSource() == C) {
            operacao = 0;
            valor_ant = 0;
            texto.setText("");
        }
        if (e.getSource() == igual){
            valor_atual = Integer.parseInt(texto.getText());
            if (operacao ==1){
                resultado = valor_ant+valor_atual;
                String res = ""+resultado;
                texto.setText(res);
            }
            if (operacao == 2) {
                resultado = valor_ant - valor_atual;
                String res = "" + resultado;
                texto.setText(res);
            }
            if (operacao == 3) {
                resultado = valor_ant * valor_atual;
                String res = "" + resultado;
                texto.setText(res);
            }
            if (operacao == 4) {
                resultado = valor_ant / valor_atual;
                String res = "" + resultado;
                texto.setText(res);
            }

        }

    }
}
