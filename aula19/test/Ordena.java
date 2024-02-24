package test;
import src.Ordenatrue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class Ordena {
    
    public int proposto[] = {9,10};
    public int esperado[] = {10,9};
    public int inesperado[] = {9};

    public Ordenatrue ordena = new Ordenatrue();
    




    @Test
    @DisplayName("Teste de teste")
    public void caso1(){
        ordena.ordenaNumeroDecrescentes(proposto);
        assertArrayEquals(proposto, esperado);
    }
}
