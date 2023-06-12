package aula9.ex4;

import java.util.Scanner;

public class Appbloco {
    public static void main(String[] args) {
        

        BlocoDeNotas bloco = new BlocoDeNotas();
        Scanner sc = new Scanner(System.in);
        int opcao = 0;
        System.out.println("Bem-vindo ao bloco de notas!\n");
        while (opcao != 5) {
            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Adicionar nota");
            System.out.println("2 - Remover nota");
            System.out.println("3 - Editar nota");
            System.out.println("4 - Mostrar todas as notas");
            System.out.println("5 - Sair");
            System.out.print("Digite a opção: ");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("\n");
                    System.out.println("Digite a nota: ");
                    String nota = sc.next();
                    bloco.addNota(nota);
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.println("\n");
                    System.out.println("Digite o índice da nota: ");
                    int index = sc.nextInt();
                    bloco.removeNota(index);
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("\n");
                    System.out.println("Digite o índice da nota: ");
                    int index2 = sc.nextInt();
                    System.out.println("Digite a nota: ");
                    String nota2 = sc.next();
                    bloco.editNota(index2, nota2);
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("\n");
                    bloco.printNotas();
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("\n");
                    System.out.println("Saindo...");
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        sc.close();
    }
}
