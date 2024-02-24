package aula16.ex1and2;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextField;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;


public class TelaDeNotas extends JFrame implements ActionListener{
    private JLabel RA;
    private JLabel Nome;
    private JLabel Sobrenome;
    private JLabel P1;
    private JLabel P2;
    private JLabel P3;
    private JLabel P4;

    private JTextField RA_tf;
    private JTextField Nome_tf;
    private JTextField Sobrenome_tf;
    private JTextField P1_tf;
    private JTextField P2_tf;
    private JTextField P3_tf;
    private JTextField P4_tf;
    private String RA_s;
    private String Nome_s;
    private String Sobrenome_s;
    private String P1_s;
    private String P2_s;
    private String P3_s;
    private String P4_s;


    private JButton escrever;
    private Formatter output;  // object used to output text to file

    public TelaDeNotas() {

        super("Notas");
        Container tela = getContentPane();
        tela.setLayout(null);
        // Instanciando os objetos
        RA = new JLabel("RA");
        Nome = new JLabel("Nome");
        Sobrenome = new JLabel("Sobrenome");
        P1 = new JLabel("P1");
        P2 = new JLabel("P2");
        P3 = new JLabel("P3");
        P4 = new JLabel("P4");


        RA_tf = new JTextField();
        Nome_tf = new JTextField();
        Sobrenome_tf = new JTextField();
        P1_tf = new JTextField();
        P2_tf = new JTextField();
        P3_tf = new JTextField();
        P4_tf = new JTextField();

        escrever = new JButton("Escrever");

        // Adicionando os objetos na tela
        Container caixa = getContentPane();

        caixa.setLayout(new BorderLayout());
        JPanel painelCenter = new JPanel(new GridLayout(7, 2));
        JPanel painelSouth = new JPanel(new FlowLayout());
    
        painelCenter.add(RA);
        painelCenter.add(RA_tf);
        painelCenter.add(Nome);
        painelCenter.add(Nome_tf);
        painelCenter.add(Sobrenome);
        painelCenter.add(Sobrenome_tf);
        painelCenter.add(P1);
        painelCenter.add(P1_tf);
        painelCenter.add(P2);
        painelCenter.add(P2_tf);
        painelCenter.add(P3);
        painelCenter.add(P3_tf);
        painelCenter.add(P4);
        painelCenter.add(P4_tf);
        painelSouth.add(escrever);

        // centrlizar texto
        RA.setHorizontalAlignment(JLabel.CENTER);
        Nome.setHorizontalAlignment(JLabel.CENTER);
        Sobrenome.setHorizontalAlignment(JLabel.CENTER);
        P1.setHorizontalAlignment(JLabel.CENTER);
        P2.setHorizontalAlignment(JLabel.CENTER);
        P3.setHorizontalAlignment(JLabel.CENTER);
        P4.setHorizontalAlignment(JLabel.CENTER);

        caixa.add(painelCenter, BorderLayout.CENTER);
        caixa.add(painelSouth, BorderLayout.SOUTH);



        escrever.addActionListener(this);



        // Posicionando os objetos na tela
        
        

        //configurando a janela
        setSize(500, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void actionPerformed( ActionEvent e ) {
        if (e.getSource() == escrever) {
            RA_s = RA_tf.getText();
            Nome_s = Nome_tf.getText();
            Sobrenome_s = Sobrenome_tf.getText();
            P1_s = P1_tf.getText();
            P2_s = P2_tf.getText();
            P3_s = P3_tf.getText();
            P4_s = P4_tf.getText();
            
            // try {
            //     analyzePath("aula16/notas.txt");
            //     FileWriter fw = new FileWriter("aula16/notas.txt", true);
            //     BufferedWriter bw = new BufferedWriter(fw);
            //     bw.write(RA + " " + Nome + " " + Sobrenome + " " + P1 + " " + P2 + " " + P3 + " " + P4);
            //     bw.newLine();
            //     bw.close();
            //     fw.close();
            // } catch (IOException e1) {
            //     e1.printStackTrace();
            // }
            openFile("aula16/notas.txt");
            addRecordsNotas();
            closeFile();

            JOptionPane.showMessageDialog(null, "Dados gravados com sucesso!");
            setVisible(false);
            TelaLogin16 tela = new TelaLogin16();
            tela.setVisible(true);


            
        }
    }

    public void addRecordsNotas()   // add records to file
   {  // object to be written to file
        try // output values to file
         {  // retrieve data to be output
               output.format( "%s %s %s %s %s %s %s \n",RA_s, Nome_s, Sobrenome_s, P1_s, P2_s, P3_s, P4_s);
                  
         }  // end try
         catch ( FormatterClosedException formatterClosedException )
         {  System.err.println( "Error writing to file." );
            return;
         } // end catch // end catch
        // end while
   } 
    public void openFile(String FileName)  // enable user to open file
    {  try
        {  output = new Formatter(FileName);
        }  // end try
        catch( SecurityException securityException )
        {  System.err.println( "You do not have write access to this file." );
            System.exit( 1 );
        }  // end catch
        catch( FileNotFoundException filesNotFoundException )
        {  System.err.println( "Error creating file." );
            System.exit( 1 );
        } // end catch
    } // end method openFile
    public void closeFile() // close file
    {  if ( output != null )
            output.close();
    }
   

    public static void analyzePath( String path )
   {  // create File object based on user input
      File name = new File( path );
      if( name.exists() ) // if name exists, output information about it
      {  // display file (or directory) information
         System.out.printf("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",
               name.getName(), " exists",
               ( name.isFile() ? "is a file" : "is not a file" ),
               ( name.isDirectory() ? "is a directory" : "is not a directory" ),
               ( name.isAbsolute() ? "is absolute path" : "is not absolute path" ), "Last modified: ",
               name.lastModified(), "Length: ", name.length(), 
               "Path: ", name.getPath(), "Absolute path: ",
               name.getAbsolutePath(), "Parent: ", name.getParent() );
         if( name.isDirectory() ) // output directory listing
         {  String directory[] = name.list();
            System.out.println( "\n\nDirectory contents:\n" );
            for( String directoryName : directory )
               System.out.printf( "%s\n", directoryName );
         } // end else
      } // end outer if
      else // not file or directory, output error message
      {  System.out.printf( "%s %s", path, "does not exist." );
      } // end else  
   } //


    
}
