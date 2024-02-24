package aula17;
// Classe “CryptoDummy.java”
import java.io.*;  
public   class test
{  private   String   textoCifrado;
   private   String  textoDecifrado;
   // converter de unicode para string
   String[] emojis = {
         "😀", "😂", "😍", "🥰", "🤩", "😎", "🥳", "😇",
         "🤪", "😜", "🤓", "😋", "😷", "🤒", "🥺", "😢",
         "😡", "🤯", "🥴", "🤮", "🤢", "🤬", "🤠", "🤡",
         "🤖", "�"
   };

   

   String[] letras = {
         "a", "b", "c", "d", "e", "f", "g", "h",
         "i", "j", "k", "l", "m", "n", "o", "p",
         "q", "r", "s", "t", "u", "v", "w", "x",
         "y", "z"
   };
   public   test()
   {  textoCifrado = "";
      textoDecifrado = "";
   }
   public void geraChave(File emoji) throws IOException  
   {  // Gera uma chave Dummy simetrica (dk: 0 a 100):
      int   dk = (int) 2;
      // Grava a chave Dummy simetrica em formato serializado  
      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(emoji));  
      oos.writeObject(dk);  
      oos.close();
   }
   public  void  geraCifra(String texto, File emoji)
   	throws   IOException, ClassNotFoundException
   {  ObjectInputStream ois = new ObjectInputStream (new FileInputStream (emoji));  
      int iDummy = (Integer) ois.readObject();
      ois.close();
      textoCifrado = texto;
      char text[] =textoCifrado.toCharArray();
      textoCifrado = "";

      for(int i = 0; i < texto.length(); i++)
      {  
         String letraString = Character.toString(text[i]);

         for(int j = 0; j < letras.length; j++)
         {
            
            if(letraString.equals(letras[j]))
            {
               if(letras.length <= j+iDummy){
                  j-=letras.length;

               }
               letraString = emojis[j+iDummy];
               break;
            }
         }
         textoCifrado += letraString;
      }
      
   }
   public  String   getTextoCifrado() throws   Exception
   {  return   textoCifrado;
   }
   public  void  geraDecifra(String texto, File emoji)
   	throws   IOException, ClassNotFoundException
   {  ObjectInputStream ois = new ObjectInputStream (new FileInputStream (emoji));  
      int iDummy = (Integer) ois.readObject();
      ois.close();
      System.out.println(texto);
      System.out.println(texto.length());
      textoDecifrado = "";
      for(int i =1; i <texto.length();i+=2){
        int inteiroString = texto.charAt(i);
        for(int j = 0; j < emojis.length ;j++){
            if(inteiroString == (int) emojis[j].charAt(1)){
               if( 0> j-iDummy){
                  j+=emojis.length;

               }
               textoDecifrado+= letras[j-iDummy];
               break;
            }
        }
      }
      

      // for(int i = 0; i < texto.length(); i++)
      // {  
      //    String letraString = Character.toString(text[i]);

      //    for(int j = 0; j < emojis.length; j++)
      //    {
      //       if(letraString.equals(emojis[j]))
      //       {
      //          letraString = letras[j-iDummy];
      //          break;
      //       }
      //    }
      //    textoDecifrado += letraString;
      // }
   }
   public  String   getTextoDecifrado()  throws   Exception
   {  return   textoDecifrado;
   }
   
   
   public static void main(String[] args) {
      test t = new test();
      Functions f = new Functions();
      File fDummy = new File("chave.emoji");
      try {
         t.geraChave(fDummy);
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      String texto = "alinesexogostosa";
      try {
         t.geraCifra(texto, fDummy);
      } catch (ClassNotFoundException | IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      f.openFile("aula17/testes/aaaaaaaaaaaaa.txt");
      f.addRecords(t.textoCifrado);
      f.closeFile();

      try {
         t.geraDecifra(t.textoCifrado, fDummy);
      } catch (ClassNotFoundException | IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      System.out.println(t.textoDecifrado);

   }
   
}



