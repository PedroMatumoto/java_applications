package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import src.Checksum;

public class TestChecksum {

    public String entrada = "Casa1";

    public Checksum checksum = new Checksum();

    @Test
    @DisplayName("Teste de teste")
    public void stingcoletada(){
        assertEquals(entrada, "Casa1");
    }

    @Test
    @DisplayName("Teste de teste")

    public void stringchararray(){
        char[] in = checksum.converterStringemCharArray(entrada);
        char[] esperado = {'C','a','s','a','1'};
        assertArrayEquals(in, esperado);
    }

    @Test
    @DisplayName("Teste de teste")
    public void charhex(){
        char [] padrão = {'a','b','c','d'};
        String in1 = checksum.charToHex(padrão[0]);
        String in2 = checksum.charToHex(padrão[1]);
        String in3 = checksum.charToHex(padrão[2]);
        String in4 = checksum.charToHex(padrão[3]);

        assertEquals(in1, "61");
        assertEquals(in2, "62");
        assertEquals(in3, "63");
        assertEquals(in4, "64");
    }

    @Test
    @DisplayName("Teste de teste")
    public void ascibin(){
        String in1 = checksum.AsciiBinario("61");
        String in2 = checksum.AsciiBinario("62");
        String in3 = checksum.AsciiBinario("63");
        String in4 = checksum.AsciiBinario("64");

        assertEquals(in1, "1100001");
        assertEquals(in2, "1100010");
        assertEquals(in3, "1100011");
        assertEquals(in4, "1100100");
    }

    @Test
    @DisplayName("Teste de teste")
    public void somabin(){
        String in1 = checksum.somaBin("1010", "1010");
        String in2 = checksum.somaBin("1", "10");
        String in3 = checksum.somaBin("11", "1");


        assertEquals(in1, "10100");
        assertEquals(in2, "11");
        assertEquals(in3, "100");
    }

    @Test
    @DisplayName("Teste de teste")
    public void inverterbits(){
        String in1 = checksum.inverterBits("1010");
        String in2 = checksum.inverterBits("1");
        String in3 = checksum.inverterBits("11");

        assertEquals(in1, "0101");
        assertEquals(in2, "0");
        assertEquals(in3, "00");
    }

    @Test
    @DisplayName("Teste de teste")
    public void somaInverso(){
        String in1 = checksum.somaNoInverso("1010");
        String in2 = checksum.somaNoInverso("1");
        String in3 = checksum.somaNoInverso("11");

        assertEquals(in1, "1011");
        assertEquals(in2, "10");
        assertEquals(in3, "100");
    }

    @Test
    @DisplayName("Teste de teste")
    public void str_array_to_char_array(){
        String[] in = {"a","b","c","d"};
        char[] esperado = {'a','b','c','d'};
        char[] in1 = checksum.StringArraytoCharArray(in);

        assertArrayEquals(in1, esperado);
    }

    @Test
    @DisplayName("Teste de teste")
    public void lerTXT_test(){
        String[] in = checksum.leChardeTXT("C:/Users/pedro/OneDrive - Instituto Maua de Tecnologia/Pastas/Instituto Mau\u00E1 de Tecnologia/3Ano/ling_prog/aula19/files/animar.txt");
        String[] esperado = {"C","a","s","a","1"};

        assertEquals(in[0], esperado[0]);
        assertEquals(in[1], esperado[1]);
        assertEquals(in[2], esperado[2]);
        assertEquals(in[3], esperado[3]);
        assertEquals(in[4], esperado[4]);
    }

    @Test
    @DisplayName("Teste de teste")
    public void escrever_test(){
        String in = "teste";
        String caminho = "aula19/teste.txt";
        checksum.escreverSomaEmTxt(in, caminho);

        String[] in1 = checksum.leChardeTXT(caminho);
        String[] esperado = {"teste"};

    }

    // @Test
    // @DisplayName("Teste de teste")
    // public void crc_test(){
    //     String in = "Casa1";
    //     String in1 = checksum.CRC-8(in);
        
    // }
    
    @Test
    @DisplayName("Teste de teste")
    public void crc_8(){
        String in = "Casa1";
        int in1 = checksum.calculateCRC8(in);
        String esperado = "0x80";

        assertEquals("0x"+Integer.toHexString(in1), esperado);
    }

    @Test
    @DisplayName("Teste de teste")
    public void calc2(){
        String in = "Casa1";
        char[] a = checksum.converterStringemCharArray(in);
        String resultado = checksum.calculaComplemento2(a);

        assertEquals(resultado,"1010111");

    }

    
}
