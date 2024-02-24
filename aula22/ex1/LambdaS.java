package ex1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaS {
    public static void main(String[] args) {
        // expresso lambda para somar dois números
        Operacao soma = (x, y) -> x + y;
        System.out.println(soma.executar(10, 20));

        Comparador <String> comparador = (String s1, String s2) -> s1.compareTo(s2);

        int resultado = comparador.compara("maçã", "banana");
        System.out.println(resultado);

        if(resultado < 0)
            System.out.println("maçã vem antes de banana");
        else if(resultado > 0)
            System.out.println("maçã vem depois de banana");
        else
            System.out.println("maçã e banana são iguais");

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> pares = numeros.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

        System.out.println(pares);
    }

    

    // interface funcional
    interface Operacao {
        int executar(int x, int y);
    }

    interface Comparador<T> {
        int compara(T o1, T o2);
    }
    
}
