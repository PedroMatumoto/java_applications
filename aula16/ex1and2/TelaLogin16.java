package aula16.ex1and2;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class TelaLogin16 extends JFrame implements ActionListener{
    Login login = new Login();
    
    private JButton cadastrar;
    private JButton Entrar;
    private JButton consultar;

    private JLabel titulo;
    private JLabel Labellogin;
    private JLabel senha;
    private JLabel ou;
    private JLabel ra;
    

    private JTextField login_tf;
    private JPasswordField senha_tf;
    private JTextField ra_tf;

    ArrayList<Login> logins = new ArrayList<Login>();
    ArrayList<Aluno> records = new ArrayList<Aluno>();

    public TelaLogin16() {
        super("Login");
        Container tela = getContentPane();
        tela.setLayout(null);
        // Instanciando os objetos
        titulo = new JLabel("Sistema de notas");
        Labellogin = new JLabel("Login:");
        senha = new JLabel("Senha:");
        login_tf = new JTextField();
        senha_tf = new JPasswordField();
        cadastrar = new JButton("Cadastrar");
        Entrar = new JButton("Entrar");
        ou = new JLabel("OU");
        ra = new JLabel("RA:");
        ra_tf = new JTextField();
        consultar = new JButton("Consultar");
        

        // Adicionando os objetos na tela
        tela.add(titulo);
        tela.add(Labellogin);
        tela.add(senha);
        tela.add(login_tf);
        tela.add(senha_tf);
        tela.add(cadastrar);
        tela.add(Entrar);
        tela.add(ou);
        tela.add(ra);
        tela.add(ra_tf);
        tela.add(consultar);

        // Posicionando os objetos na tela
        titulo.setBounds(150, 10, 100, 20);
        Labellogin.setBounds(50, 50, 100, 20);
        login_tf.setBounds(100, 50, 200, 20);
        senha.setBounds(50, 80, 100, 20);
        senha_tf.setBounds(100, 80, 200, 20);
        cadastrar.setBounds(50, 120, 100, 20);
        Entrar.setBounds(200, 120, 100, 20);
        ou.setBounds(180, 150, 100, 20);
        ra.setBounds(50, 180, 100, 20);
        ra_tf.setBounds(100, 180, 200, 20);
        consultar.setBounds(140, 210, 100, 20);

        // Adicionando o listener aos objetos
        cadastrar.addActionListener(this);
        Entrar.addActionListener(this);
        consultar.addActionListener(this);

        // Configurações da tela
        setSize(400, 300);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
   

    public void actionPerformed( ActionEvent e ) {
        if (e.getSource() == cadastrar) {
            login.setNome(login_tf.getText());
            login.setSenha(senha_tf.getText());
            if(login.getNome().equals("") || login.getSenha().equals("")){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                return;
            }
            // se o nome já existir no arquivo
            String nomeArquivo = "aula16/login.txt";
            String linha = "";
            String[] dados = new String[2];
            boolean achou = false;
            try {
                TelaDeNotas.analyzePath(nomeArquivo);
                FileReader fr = new FileReader(nomeArquivo);
                BufferedReader br = new BufferedReader(fr);
                while ((linha = br.readLine()) != null) {
                    dados = linha.split(";");
                    if (login.getNome().equals(dados[0])) {
                        achou = true;
                        break;
                    }
                }
                br.close();
                fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (achou) {
                JOptionPane.showMessageDialog(null, "Usuário já cadastrado!");
                return;
            }

            // escrever em txt
            openFile(nomeArquivo);
            addRecordsSenhas(login);
            closeFile();
            // try {
            //     FileWriter fw = new FileWriter("aula16/login.txt", true);
            //     BufferedWriter bw = new BufferedWriter(fw);
            //     bw.write(login.getNome() + ";" + login.getSenha());
            //     bw.newLine();
            //     bw.close();
            //     fw.close();
            // } catch (IOException ex) {
            //     ex.printStackTrace();
            // }
            
        }
    
       
        if(e.getSource()== Entrar){
            String nome = login_tf.getText();
            String senha = senha_tf.getText();
            String nomeArquivo = "aula16/login.txt";
            String linha = "";
            String[] dados = new String[2];
            boolean achou = false;
            
            // percorre a lista de logins
            openFileRead(nomeArquivo);
            readRecords();
            closeFileRead();
            for (Login l : logins) {
                if (nome.equals(l.getNome()) && senha.equals(l.getSenha())) {
                    achou = true;
                    break;
                }
            }
            // try {
            //     TelaDeNotas.analyzePath(nomeArquivo);
            //     FileReader fr = new FileReader(nomeArquivo);
            //     BufferedReader br = new BufferedReader(fr);
            //     while ((linha = br.readLine()) != null) {
            //         dados = linha.split(";");
            //         if (nome.equals(dados[0]) && senha.equals(dados[1])) {
            //             achou = true;
            //             break;
            //         }
            //     }
            //     br.close();
            //     fr.close();
            // } catch (IOException ex) {
            //     ex.printStackTrace();
            // }
            if (achou) {
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                dispose();
                TelaDeNotas tela = new TelaDeNotas();
                tela.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos!");
            }
        }
        if(e.getSource()==consultar){

            String nome = ra_tf.getText();
            String nomeArquivo = "aula16/notas.txt";
            String linha = "";
            String[] dados = new String[7];
            boolean achou = false;
            // try {
            //     TelaDeNotas.analyzePath(nomeArquivo);
            //     FileReader fr = new FileReader(nomeArquivo);
            //     BufferedReader br = new BufferedReader(fr);
            //     while ((linha = br.readLine()) != null) {
            //         dados = linha.split(" ");
            //         if (nome.equals(dados[0])) {
            //             achou = true;
            //             break;
            //         }
            //     }
            //     //calcular media
            //     br.close();
            //     fr.close();
                
            // } catch (IOException ex) {
            //     ex.printStackTrace();
            // }
            openFileRead(nomeArquivo);
            readRecordsRA();
            closeFileRead();

            for (Aluno a : records) {
                if (nome.equals(a.getRA())) {
                    achou = true;
                    break;
                }
            }

            if (achou) {
                JOptionPane.showMessageDialog(null, "RA encontrado!");
                dispose();
                //JOptionPane.showMessageDialog(null, "Nome: " + dados[1]+ "\n" + "Sobrenome: " + dados[2] + "\n" + "RA: " + dados[0] + "\n" + "Média: " +(Double.parseDouble(dados[3]) + Double.parseDouble(dados[4]) + Double.parseDouble(dados[5]) + Double.parseDouble(dados[6])) / 4);
                JOptionPane.showMessageDialog( null, "Nome: " + records.get(0).getNome() + "\n" + "Sobrenome: " + records.get(0).getSobrenome() + "\n" + "RA: " + records.get(0).getRA() + "\n" + "Média: " +(Double.parseDouble(records.get(0).getP1()) + Double.parseDouble(records.get(0).getP2()) + Double.parseDouble(records.get(0).getP3()) + Double.parseDouble(records.get(0).getP4())) / 4);
                //colocar tudo em um objeto Aluno);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "RA não encontrado!");
            }
        }
    }
    private Formatter output;  // object used to output text to file

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

   public void addRecordsSenhas(Login record)   // add records to file
   {  // object to be written to file
        try // output values to file
         {  // retrieve data to be output
               output.format( "%s %s\n", record.getNome(), 
                  record.getSenha());
         }  // end try
         catch ( FormatterClosedException formatterClosedException )
         {  System.err.println( "Error writing to file." );
            return;
         } // end catch // end catch
        // end while
   }  // end method addRecords

   public void closeFile() // close file
   {  if ( output != null )
         output.close();
   }

   

   /* =============================================== */
   private Scanner input;
   // enable user to open file
   public void openFileRead(String FileName)
   {  try
      {  input = new Scanner( new File( FileName) );
      }  // end try
      catch ( FileNotFoundException fileNotFoundException )
      {  System.err.println( "Error opening file." );
         System.exit( 1 );
      }  // end catch
   }  // end method openFile

   public void readRecords()  // read record from file
   {  // object to be written to screen
      Login record = new Login();
      try   // read records from file using Scanner object
      {  while( input.hasNext() )
         {  record.setNome( input.next() ); // read account number
            record.setSenha( input.next() ); // read first name
            logins.add(record);

         }  // end while
      }  // end try
      catch( NoSuchElementException elementException )
      {  System.err.println( "File improperly formed." );
         input.close();
         System.exit( 1 );
      }  // end catch
      catch( IllegalStateException stateException )
      {  System.err.println( "Error reading from file." );
         System.exit( 1 );
      }  // end catch
   }  // end method readRecords

   public void readRecordsRA(){
        Aluno record = new Aluno();
        try   // read records from file using Scanner object
        {  while( input.hasNext() )
           {  record.setRA( input.next() ); // read account number
              record.setNome( input.next() ); // read first name
              record.setSobrenome( input.next() ); // read last name
              record.setP1( input.next() ); // read balance
              record.setP2( input.next() ); // read balance
              record.setP3( input.next() ); // read balance
              record.setP4( input.next() ); // read balance
              records.add(record);
           }
        }  // end try
        catch( NoSuchElementException elementException )
        {  System.err.println( "File improperly formed." );
           input.close();
           System.exit( 1 );
        }  // end catch
        catch( IllegalStateException stateException )
        {  System.err.println( "Error reading from file." );
           System.exit( 1 );
        }  // end catch


   }

   public void closeFileRead() // close file and terminate application
   {  if( input != null )
         input.close(); // close file
   }  // end method closeFile
}
