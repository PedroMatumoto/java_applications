package aula5.lab;

import java.math.BigInteger;

public class ex7 {
    public static void main(String[] args) {
        int i = 120;
        BigInteger produto = BigInteger.valueOf(1);
        while (i < 300) {
            produto=produto.multiply(BigInteger.valueOf(i));
            i++;
        }
        System.out.println(produto);
    }

}
