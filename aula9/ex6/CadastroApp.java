package aula9.ex6;

import java.util.Scanner;

public class CadastroApp {
    public static void main(String[] args) {
        BancoDeClientes banco = new BancoDeClientes();

        System.out.println("Bem - vindo ao gerenciador de clientes!");

        int opcao=0;

        Scanner sc = new Scanner(System.in);

        while(opcao!=6){
            System.out.println("Selecione uma opcao: ");
            System.out.println("1 - Adicionar cliente");
            System.out.println("2 - Remover cliente");
            System.out.println("3 - Alterar cliente");
            System.out.println("4 - Listar dados de um cliente");
            System.out.println("5 - Listar todos os clientes");
            System.out.println("6 - Sair do sistema");
            System.out.print("Digite a opção: ");

            opcao = sc.nextInt();
            switch(opcao){
                case 1:
                    System.out.println("\n");
                    System.out.println("Digite o nome do cliente: ");
                    String nome = sc.next();
                    System.out.println("Digite o telefone do cliente: ");
                    String telefone = sc.next();
                    System.out.println("Digite o ID do cliente: ");
                    int id = sc.nextInt();
                    Cliente cliente = new Cliente(nome, telefone, id);
                    banco.adicionarCliente(cliente);
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.println("\n");
                    System.out.println("Digite o nome do cliente: ");
                    String nome2 = sc.next();
                    banco.removerCliente(nome2);
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("\n");
                    System.out.println("Digite o nome do cliente: ");
                    String nome4 = sc.next();
                    System.out.println("Digite o telefone do cliente: ");
                    String telefone4 = sc.next();
                    System.out.println("Digite o ID do cliente: ");
                    int id4 = sc.nextInt();
                    banco.alterarCliente(nome4, telefone4, id4);
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("\n");
                    System.out.println("Digite o nome do cliente: ");
                    String nome3 = sc.next();
                    banco.encontrarCliente(nome3);
                    System.out.println("\n");
                    break;
                case 5:
                    System.out.println("\n");
                    banco.listarClientes();
                    System.out.println("\n");
                    break;
                case 6:
                    System.out.println("\n");
                    System.out.println("Saindo do sistema...");
                    System.out.println("\n");
                    break;
                }
            }
    }
    
}
