package aula10.TickTack;

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

public class TelaRelogio extends JFrame implements ActionListener {
    private JButton TicTac;
    private JButton Hora;
    private JButton Minuto;
    Relogio r = new Relogio();

    private JLabel mo;

    // construtor
    public TelaRelogio() {
        // setar cabeçalho
        super("Relogio");
        // criar botoes
        this.TicTac = new JButton("TicTac");
        this.Hora = new JButton("Hora");
        this.Minuto = new JButton("Minuto");
        // criar campos de texto
        this.mo = new JLabel(r.mostrador);
        // configuração do layout
        Container caixa = getContentPane();
        caixa.setLayout(new BorderLayout());
        JPanel painelCentro = new JPanel(new FlowLayout());
        JPanel painelSul = new JPanel(new GridLayout(1, 3));
        painelCentro.add(mo);
        painelSul.add(TicTac);
        painelSul.add(Hora);
        painelSul.add(Minuto);
        caixa.add(painelSul, BorderLayout.SOUTH);
        caixa.add(painelCentro, BorderLayout.CENTER);
        // configurar botões
        TicTac.addActionListener(this);
        Hora.addActionListener(this);
        Minuto.addActionListener(this);
        // definir tamanho da janela
        setSize(400, 100);
        // botão de saída encerra o programa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == TicTac) {
            r.ticTac();
            mo.setText(r.mostrador);
        }
        if (e.getSource() == Hora) {
            int inputhora = Integer.parseInt(JOptionPane.showInputDialog("Hora: "));
            if (inputhora > 24) {
                JOptionPane.showMessageDialog(null, "Valor inválido");
            }
            if (inputhora < 0) {
                JOptionPane.showMessageDialog(null, "Valor inválido");
            }
            if (inputhora>0 && inputhora<24){
                r.hora.setValor(inputhora);
                mo.setText(r.hora.mostra() + ":" + r.minuto.mostra());
            }
           
        }
        if (e.getSource() == Minuto) {
            int inputminuto = Integer.parseInt(JOptionPane.showInputDialog("Minuto: "));
            if(inputminuto>60){
                JOptionPane.showMessageDialog(null,"Valor inválido");
            }
            if (inputminuto < 0) {
                JOptionPane.showMessageDialog(null, "Valor inválido");
            }
            if (inputminuto > 0 && inputminuto < 60) {
                r.minuto.setValor(inputminuto);
                mo.setText(r.hora.mostra() + ":" + r.minuto.mostra());
            }
        }
    }
}
