package aula10.Mostrar_Limpar;

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

public class TelaMostrar extends JFrame implements ActionListener {
    private JButton botao_mostrar;
    private JButton botao_limpar;
    private JButton botao_sair;

    private JTextField texto;
    private JLabel etiqueta;

    // construtor
    public TelaMostrar() {
        //setar cabeçalho
        super("App_Show");
        //criar botoes
        this.botao_mostrar = new JButton("Mostrar");
        this.botao_limpar = new JButton("Limpar");
        this.botao_sair = new JButton("Sair");
        //criar campos de texto
        this.texto = new JTextField(" ", 10);
        this.etiqueta = new JLabel("Texto: ");
        //configuração do layout
        Container caixa = getContentPane();
        caixa.setLayout(new BorderLayout());
        JPanel painelCentro= new JPanel(new FlowLayout());
        JPanel painelSul = new JPanel(new GridLayout(1, 3));
        painelCentro.add(etiqueta);
        painelCentro.add(texto);
        painelSul.add(botao_limpar);
        painelSul.add(botao_sair);
        painelSul.add(botao_mostrar);
        caixa.add(painelSul,BorderLayout.SOUTH);
        caixa.add(painelCentro, BorderLayout.CENTER);
        //configurar botões
        botao_limpar.addActionListener(this);
        botao_sair.addActionListener(this);
        botao_mostrar.addActionListener(this);
        //definir tamanho da janela
        setSize(400, 100);
        //botão de saída encerra o programa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botao_mostrar) {
            String word = texto.getText();
            if(word.length()<10){
                JOptionPane.showMessageDialog(null, word);
            }
            if(word.length()>10){
                JOptionPane.showMessageDialog(null, "Palavra muito grande!");
            }
        }
        if (e.getSource() == botao_limpar) {
            texto.setText("");
        }
        if (e.getSource() == botao_sair) {
            System.exit(0);
        }
    }
}
