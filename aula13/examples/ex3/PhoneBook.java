package aula13.examples.ex3;
import java.awt.*;
import javax.swing.*;

public class PhoneBook extends JFrame{
    JPanel background;
    JTable table;
    JScrollPane scrollPane;
    Object [][] data = 
    {
        {"2001","Antonio","11 91234-5678","antonio@gmail.com"},
        {"2002","Bruno","11 91234-5678","bruno@gmail.com"},
        {"2003","Carlos","11 91234-5678","carlos@gmail.com"},
        {"2004","Daniel","11 91234-5678","daniel@gmail.com}"}
    };
    String [] columns = {"ID","Nome","Telefone","Email"};

    public PhoneBook(){
        super("Agenda");
    }

    public void makeWindow(){
        background = new JPanel();
        background.setLayout(new FlowLayout());
        table = new JTable(data,columns);
        scrollPane = new JScrollPane(table);
        background.add(scrollPane);
        add(background);
        setSize(500, 200);
        setVisible(true);
    }  
}
