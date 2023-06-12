package aula5.lab;

import javax.swing.JOptionPane;

public class ex23 {
    public static void main(String[] args) {

        double quant = 0;

        double preco = 0;

        double soma=0;
        do {
            String qua = JOptionPane.showInputDialog("Quantidade:");
            quant = Double.parseDouble(qua);
            
            if(quant<0) System.out.println("Quantidade incoerente");
            else{
                String pre = JOptionPane.showInputDialog("Preço:");
                preco = Double.parseDouble(pre);

                if (preco < 0)
                    System.out.println("Valor incoerente");
                        else 
                            soma = soma + (quant * preco);

               
            };

            
        } while (quant != 0);
            System.out.println("Valor total: "+soma);

    }

}
