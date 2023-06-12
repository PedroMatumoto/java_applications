package aula11.teoria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dialogo1 extends JDialog implements ActionListener{
    JLabel lb;
    JTextField tf;
    JButton bt;
    int valor;
    public Dialogo1(JFrame fr)
    {
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
        setSize(200, 100);
        setLocation(200,200);
        setTitle("Valores");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==bt){
        valor = Integer.parseInt(tf.getText());
        dispose();
        }
    }

    public int getValor()
    {
        return valor;
    }



    
}
