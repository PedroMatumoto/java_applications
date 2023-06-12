package VIEW;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class TelaInicial extends JFrame implements ActionListener {
    private JButton cadastrar;
    private JButton pesquisar;
    private JButton gerar;
    private JButton excluir;
    private JButton alterar;

    private JLabel titulo;

    // construtor
    public TelaInicial() {
        super("Tela Inicial");
        
        ImageIcon imagemIcon = new ImageIcon("src/VIEW/img_pgc.png");
        imagemIcon.setImage(imagemIcon.getImage().getScaledInstance(900, 450, 1));
        JLabel label = new JLabel(imagemIcon);
        label.setIcon(imagemIcon);
        
        this.cadastrar = new JButton("Cadastrar");
        this.pesquisar = new JButton("Pesquisar usuário");
        this.gerar = new JButton("Gerar certificados");
        this.excluir = new JButton("Excluir cadastros");
        this.alterar = new JButton("Alterar cadastro");
        this.titulo = new JLabel("Bem vindo ao sistema de certificados!");
        Container caixa = getContentPane();

        caixa.setLayout(new BorderLayout());
        JPanel painelcima = new JPanel(new FlowLayout());
        JPanel painelCenter = new JPanel(new FlowLayout());
        JPanel painelbaixo = new JPanel(new GridLayout(1, 5));
        Font fonteINI = new Font("Roboto", Font.BOLD, 16);
        titulo.setFont(fonteINI);
        cadastrar.setFont(fonteINI);
        pesquisar.setFont(fonteINI);
        gerar.setFont(fonteINI);
        excluir.setFont(fonteINI);
        alterar.setFont(fonteINI);
        painelcima.add(titulo);
        painelbaixo.add(cadastrar);
        painelbaixo.add(alterar);
        painelbaixo.add(excluir);
        painelbaixo.add(pesquisar);
        painelbaixo.add(gerar);
        painelCenter.add(label);

        caixa.add(painelCenter, BorderLayout.CENTER);
        caixa.add(painelbaixo, BorderLayout.SOUTH);
        caixa.add(painelcima, BorderLayout.NORTH);

        cadastrar.addActionListener(this);
        pesquisar.addActionListener(this);
        gerar.addActionListener(this);
        excluir.addActionListener(this);
        alterar.addActionListener(this);

        setSize(1000, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cadastrar) {
            TelaCadastro tc = new TelaCadastro();
            while(tc.getConfirmar()!=true){
                setVisible(false);
            }
        }
        if (e.getSource() == pesquisar) {
            TelaPesquisa tp = new TelaPesquisa();
            while(tp.getConfirmar()!=true){
                setVisible(false);
            }
        }
        if (e.getSource() == gerar) {
            gerarCertificado();
        }
        if(e.getSource() == alterar){
            TelaAlterar ta = new TelaAlterar();
            while(ta.getConfirmar()!=true){
                setVisible(false);
            }
        }
        if(e.getSource() == excluir){
            TelaExcluir te = new TelaExcluir();
            while(te.getConfirmar()!=true){
                setVisible(false);
            }
        }
    }

    public void gerarCertificado() {
        TelaGerarCertificado tgc = new TelaGerarCertificado();
        while(tgc.getConfirmar()!=true){
            setVisible(false);
        }
    }
}
