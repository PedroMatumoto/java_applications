package aula5.lab;

import java.math.BigInteger;

public class ex8 {
    public static void main(String[] args) {
        int i = 1;
        BigInteger produto = BigInteger.valueOf(0);
        while (i <= 100) {
            produto = produto.add(BigInteger.valueOf(i));
            i++;
        }
        System.out.println(produto);
    }

}
