package aula8.ex2;

import java.io.ObjectInputStream.GetField;

public class Desempregado extends PessoaFisica {
    private double seguroDesemprego;
    public Desempregado(){
        super();
        seguroDesemprego=0.0;
    }
    
    public Desempregado(String nome, String sobrenome, String cpf, double seguroDesemprego) {
        super(nome,sobrenome,cpf);
        this.seguroDesemprego = seguroDesemprego;
    }

    public void setseguroDesemprego(double seguroDesemprego){
        this.seguroDesemprego=seguroDesemprego;
    }

    public double getseguroDesemprego() {
        return seguroDesemprego;
    }

    @Override
    public String Dados(){
        String msg = super.Dados()+ "\nDesempregado: "+ getseguroDesemprego();
        return msg;
    }


    
}
