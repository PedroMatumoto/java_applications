package aula5.lab;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class ex25 {
    public static void main(String[] args) {
        
        System.out.println("Numero real:");
        Scanner sn = new Scanner(System.in);
        double num1 = sn.nextDouble();

        System.out.println("Número real:");
        double num2 = sn.nextDouble();

        double resultado=0;

        int opcao=0;


        while (opcao!=9){
            System.out.println("Operações disponíveis:");
            System.out.println("1. Adição;");
            System.out.println("2. Subtração;");
            System.out.println("3. Multiplicação;");
            System.out.println("4. Divisão;");
            System.out.println("9. Sair do programa");

            System.out.println("Opcao:");
            opcao = sn.nextInt();

            switch (opcao) {
                case 1:
                    resultado = num1 + num2;
                
                    System.out.println("\nResultado: "+resultado+"\n");
                    break;
                case 2:
                    resultado = num1 - num2;
                    System.out.println("\nResultado: " + resultado + "\n");
                    break;
                case 3:
                    resultado = num1 * num2;
                    System.out.println("\nResultado: " + resultado + "\n");
                    break;
                case 4:
                    if (num2 != 0) {
                        resultado = num1 / num2;
                        System.out.println("\nResultado: " + resultado + "\n");
                    } else
                        System.out.println("Divisão por zero!");
                    break;
                default:
                System.out.println("Operação inválida!");
                break;
                case 9:
                System.out.println("Saindo...");
                
            }}

    }
    
}
