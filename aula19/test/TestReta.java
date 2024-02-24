package test;
import src.Reta;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TestReta {
    public int base = 5;
    public int altura = 2;

    public Reta reta = new Reta();


    @Test
    @DisplayName("Teste de teste")
    public void casoArea() {
        assertEquals(5*2,reta.calcularArea(base, altura));
    }

    @Test
    @DisplayName("Teste de teste")
    public void casoPerimetro() {
        assertEquals(2*(5+2),reta.calcularPerimetro(base, altura));
    }

    
}
