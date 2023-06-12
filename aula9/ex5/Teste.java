package aula9.ex5;

import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        
        Deposito deposito = new Deposito();

        System.out.println("Bem - vindo ao gerenciador de caixas!");

        int opcao=0;

        Scanner sc = new Scanner(System.in);

        while(opcao!=7){
            System.out.println("Selecione uma opcao: ");
            System.out.println("1 - Adicionar caixa");
            System.out.println("2 - Remover caixa");
            System.out.println("3 - Procurar caixa");
            System.out.println("4 - Alterar caixa de corredor e posição");
            System.out.println("5 - Listar todas as caixas");
            System.out.println("6 - Listar caixas mais pesadas que 10kg");
            System.out.println("7 - Sair do sistema");
            System.out.print("Digite a opção: ");

            opcao = sc.nextInt();
            switch(opcao){
                case 1:
                    System.out.println("\n");
                    System.out.println("Digite o corredor da caixa: ");
                    String corredor = sc.next();
                    System.out.println("Digite o peso da caixa: ");
                    double peso = sc.nextDouble();
                    System.out.println("Digite o dono da caixa: ");
                    String dono = sc.next();
                    System.out.println("Digite a posição da caixa: ");
                    int posicao = sc.nextInt();
                    Caixa caixa = new Caixa(corredor, posicao, peso, dono);
                    deposito.adicionarCaixa(caixa);
                    System.out.println("\n");
                    break;
                case 2:
                    System.out.println("\n");
                    System.out.println("Digite o nome do dono: ");
                    String nome2 = sc.next();
                    deposito.removerCaixa(nome2);
                    System.out.println("\n");
                    break;
                case 3:
                    System.out.println("\n");
                    System.out.println("Digite o nome da caixa: ");
                    String nome3 = sc.next();
                    if(deposito.encontrarCaixa(nome3)==-1){
                        System.out.println("Caixa não encontrada!");
                    }
                    else
                    System.out.println("Caixa deste dono no índice: "+deposito.encontrarCaixa(nome3));
                    
                    System.out.println("\n");
                    break;
                case 4:
                    System.out.println("\n");
                    System.out.println("Digite o nome do dono: ");
                    String nome4 = sc.next();
                    System.out.println("Digite o novo corredor da caixa: ");
                    String corredor2 = sc.next();
                    System.out.println("Digite a nova posição da caixa: ");
                    int posicao2 = sc.nextInt();
                    deposito.moverCaixa(nome4, corredor2, posicao2);
                    System.out.println("\n");
                    break;

                case 5:
                    System.out.println("\n");
                    deposito.ListarCaixas();;
                    System.out.println("\n");
                    break;
                case 6:
                    System.out.println("\n");
                    System.out.println("Peso das caixas: ");
                    int pesosearch = sc.nextInt();
                    int[] indices = deposito.caixasMaisPesadasque(pesosearch);
                    System.out.println("Caixas com peso maior que 10kg nos índices: ");
                    for (int i = 0; i < indices.length; i++) {
                        if(indices[i]!=-1)
                        System.out.println(indices[i]);
                    }
                    System.out.println("\n");
                    break;
                case 7:
                    System.out.println("\n");
                    System.out.println("Saindo...");
                    System.out.println("\n");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }
    
}
