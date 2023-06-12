package aula10.calculadora;

//imports
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class TelaCalculadora extends JFrame implements ActionListener{
    private JButton botao;
    private JTextField texto;
    private JLabel etiqueta;

    //construtor
    public TelaCalculadora(){
    super("Tela Inicial");
    this.botao = new JButton("Soma"); 
    this.texto = new JTextField("0",10);
    this.etiqueta=new JLabel("Valor: ");
    Container caixa = getContentPane();
    // caixa.setLayout(new BorderLayout());
    // caixa.add(etiqueta, BorderLayout.WEST);
    

    caixa.setLayout(new FlowLayout());
    caixa.add(etiqueta);
    caixa.add(texto);
    caixa.add(botao);
    botao.addActionListener(this);
    setSize(200, 100);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
       if(e.getSource()==botao){
        int valor=Integer.parseInt(texto.getText());
        valor+=10;
        texto.setText(""+valor);
       }
    }   
}


