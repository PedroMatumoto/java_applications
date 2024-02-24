package src;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.util.zip.CRC32;

public class Checksum {
    

    public static String somaNoInverso(String invertido){
            String somado = Integer.toBinaryString(Integer.parseInt(invertido, 2) + 1);
            return somado;
        }
        
    public static String inverterBits(String entrada){
        String invertido = "";
        for (int i = 0; i < entrada.length(); i++) {
            if (entrada.charAt(i) == '0') {
                invertido += "1";
            } else {
                invertido += "0";
            }
        }
        return invertido;
    }
    public static String[] leChardeTXT(String nomeArquivo) {
        // ler um arquivo txt e armazenar em um array de char
        String linha = "";
        String[] dados = null;
        try{
            FileReader fr = new FileReader(nomeArquivo);
            BufferedReader br = new BufferedReader(fr);
            while ((linha = br.readLine()) != null) {
                dados = linha.split(" ");
                
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        return dados;
    }

    public static char[] converterStringemCharArray(String entrada){
        char[] palavra = entrada.toCharArray();
        char[] palavralimpa = new char[palavra.length];
        int j = 0;
        for (int i = 0; i < palavra.length; i++) {
            if (palavra[i] != ' ') {
                palavralimpa[j] = palavra[i];
                j++;
            }
        }
        return palavralimpa;
    }
    public static void escreverSomaEmTxt(String soma, String nomeArquivo) {
            // escrever o resultado em um arquivo txt
            try {
            FileWriter fw = new FileWriter(nomeArquivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Soma: " + soma+"\n");
            bw.close();
            fw.close();
            System.out.println("\n\n ===== Arquivo gravado com sucesso! =====");
            } catch (IOException ex) {
            ex.printStackTrace();
            }
            
        }


    public static char[] StringArraytoCharArray(String[] entrada){
        char[] palavras = new char[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            palavras[i] = entrada[i].charAt(0);
        }
        return palavras;
    }
    public static String charToHex(char c) {
        return Integer.toHexString((int) c);
    }

    public static String AsciiBinario(String ascii){
        String binario = Integer.toBinaryString(Integer.parseInt(ascii, 16));
        return binario;
    }

    public static String calculaComplemento2(char [] palavralimpa){
            // converter cada valor de char para ascii hex
        String[] ascii = new String[palavralimpa.length];
        for (int i = 0; i < palavralimpa.length; i++) {
            ascii[i] = charToHex(palavralimpa[i]);
        }

        // printando o array de ascii
        System.out.print("Array de ascii: ");
        for (int i = 0; i < ascii.length; i++) {
            System.out.print(ascii[i] + " ");
        }
        System.out.println();

        // converter cada valor de ascii para binario
        String[] binario = new String[ascii.length];
        for (int i = 0; i < ascii.length; i++) {
            binario[i] = AsciiBinario(ascii[i]);
        }

        // printando o array de binario
        System.out.print("Array de binario: ");
        for (int i = 0; i < binario.length; i++) {
            System.out.print(binario[i] + " ");
        }

        // somando os valores de binario em binario
        String soma = binario[0];
        for (int i = 1; i < binario.length; i++) {
            soma = somaBin(soma, binario[i]);
        }

        // printando a soma
        System.out.println("\nSoma: " + soma);


        // descartando o bit de overflow
        soma = soma.substring(1);
        System.out.println("Soma sem overflow: " + soma);

        // invertendo os bits
        String invertido = inverterBits(soma);
        System.out.println("Soma invertida: " + invertido);

        // somando 1 ao valor invertido
        String somado = somaNoInverso(invertido);
        System.out.println("Soma invertida + 1: " + somado);
        return somado;
        }

    public static String somaBin(String bin1, String bin2){
        String soma = Integer.toBinaryString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2));
        return soma;
    }

    public static int calculateCRC8(String input) {
        int POLYNOMIAL = 0x07;
        int INITIAL_VALUE = 0x00;
        int crc = INITIAL_VALUE;
        byte[] data = input.getBytes();

        for (byte b : data) {
            crc ^= b;
            for (int j = 0; j < 8; j++) {
                if ((crc & 0x80) != 0) {
                    crc = (crc << 1) ^ POLYNOMIAL;
                } else {
                    crc <<= 1;
                }
            }
        }

        return crc & 0xFF; // Ensure the result is an 8-bit value
    }
        
    // Calculo CRC
    /*Para calcular um CRC de n bits, coloque os bits 
    representando o dado em uma linha, e abaixo do MSB dessa 
    linha posicione o padrão (n + 1)-bit que representa o divisor CRC, 
    também chamado de "polinômio".*/

    /*Divida o dado por esse padrão, usando a divisão binária
    (com descarte de resto). O resultado dessa divisão é o CRC.*/

    /*Para verificar o dado, divida-o pelo padrão. Se o resto for zero,
    o dado está correto. Caso contrário, houve um erro na transmissão.*/

    
    public static void main(String[] args) {

        System.out.println(" ======= Testes unitários =======");
        // testes unitários
        System.out.println(" ===== Teste charToHex =====");
        char[] teste1 = { 'a', 'b', 'c', 'd' };
        for(int i = 0; i < teste1.length; i++){
            System.out.print(charToHex(teste1[i])+ " ");
        }

        System.out.println("\n\n ===== Teste AsciiBinario =====");
        String[] teste3 = { "61", "62", "63", "64" };
        for(int i = 0; i < teste3.length; i++){
            System.out.print(AsciiBinario(teste3[i])+ " ");
        }

        System.out.println("\n\n ===== Teste somaBin =====");

        System.out.println(somaBin("1010", "1010"));

        System.out.println("\n\n ===== Teste inverterBits =====");
        System.out.println(inverterBits("1010"));

        System.out.println("\n\n ===== Teste somaNoInverso =====");
        System.out.println(somaNoInverso("1010"));

        System.out.println("\n\n ===== Teste converterStringemCharArray =====");
        String teste4 = "a b c d";
        char[] teste5 = converterStringemCharArray(teste4);
        for(int i = 0; i < teste5.length; i++){
            System.out.print(teste5[i]);
        }

        System.out.println("\n\n ===== Teste StringArraytoCharArray =====");
        String[] teste6 = { "a", "b", "c", "d" };
        char[] teste7 = StringArraytoCharArray(teste6);
        for(int i = 0; i < teste7.length; i++){
            System.out.print(teste7[i]);
        }

        System.out.println("\n\n ===== Teste CRC =====");




        System.out.println("\n\n ===== Ler de txt =====");
        String[] teste2 = leChardeTXT("files/animar.txt");
        for(int i = 0; i < teste2.length; i++){
            System.out.print(teste2[i]);
        }

        System.out.println("\n\n ===== Teste escrever =====");
        escreverSomaEmTxt("teste", "aula18/teste.txt");


        // entrar com um array de char e printar
        String entrada = JOptionPane.showInputDialog("Digite uma array de caracteres separados por espaço:");
        char[] palavralimpa = converterStringemCharArray(entrada);
        String saida = calculaComplemento2(palavralimpa);
        System.out.print("\nResultado: "+saida+"\n\n");

        System.out.println(" ===== Por arquivo txt =====");

        String[] arquivosText = leChardeTXT("aula18/entrada.txt");
        // converter as strings para char
        char[] palavras = StringArraytoCharArray(arquivosText);
        saida = calculaComplemento2(palavras);
        System.out.print("Resultado: "+saida);
        escreverSomaEmTxt(saida, "aula18/saida.txt");

    }

    
}
