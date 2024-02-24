package aula13.examples.ex1;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ComboBoxFrame extends JFrame {

    private JComboBox imagesJComboBox;
    private JLabel label;
    private String names[] = {"Eevee", "Arvorinha", "Sad Pikachu", "Pet Pikachu"};
    private Icon icons[] = {
        new ImageIcon("pokemon-imagem-animada-0032.gif"),
        new ImageIcon("download.png"),
        new ImageIcon("pokemon-cute.gif"),
        new ImageIcon("aniyuki-pokemon-25.gif")};

    public ComboBoxFrame() {
        super("Testando JComboBox");
        setLayout(new FlowLayout());
        

        imagesJComboBox = new JComboBox(names);
        imagesJComboBox.setMaximumRowCount(3);
        imagesJComboBox.addItemListener(
                new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    label.setIcon(icons[imagesJComboBox.getSelectedIndex()]);
                }
            }
        }
        );
        add(imagesJComboBox);
        label = new JLabel(icons[0]);
        add(label); 
        setLocationRelativeTo(null);
        setSize(500, 500);
        setVisible(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
