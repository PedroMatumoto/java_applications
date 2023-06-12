package aula11.teoria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Dialogo2 extends JDialog implements ActionListener {
    JLabel lb;
    JTextField tf;
    JButton bt;
    int valor;

    public Dialogo2(JFrame fr) {
        super(fr, true);
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());
        lb = new JLabel("Valor: ");
        cp.add(lb);
        tf = new JTextField(10);
        cp.add(tf);
        bt = new JButton("OK");
        cp.add(bt);
        bt.addActionListener(this);
        JMenu x = new JMenu("Arquivo");
        x.setMnemonic('A');
        x.addSeparator();
        JMenuItem y = new JMenuItem("Cor");
        y.setMnemonic('C');
        JMenuBar barra = new JMenuBar();
        setJMenuBar(barra);
        barra.add(x);
        x.add(y);
        y.addActionListener(this);
        JRadioButton radio1 = new JRadioButton("Plain", true);
        JRadioButton radio2 = new JRadioButton("Bold", false);
        JCheckBox check = new JCheckBox("Italic");
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radio1);
        grupo.add(radio2);
        cp.add(radio1);
        cp.add(radio2);
        cp.add(check);



        setSize(300, 100);
        setLocation(500, 500);
        setTitle("Valores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt) {
            valor = Integer.parseInt(tf.getText());
            dispose();
        }
        
    }

    static int getValor(JFrame fr) {
        Dialogo2 d1 = new Dialogo2(fr);
        return d1.valor;
    }

}
