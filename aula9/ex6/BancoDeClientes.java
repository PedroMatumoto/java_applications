package aula9.ex6;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BancoDeClientes{
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void removerCliente(String nome){
        for(int i=0; i<clientes.size(); i++){
            if(clientes.get(i).getNome().equals(nome)){
                clientes.remove(i);
            }
        }
    }

    public void encontrarCliente(String nome){
        for(int i=0; i<clientes.size(); i++){
            if(clientes.get(i).getNome().equals(nome)){
                System.out.println("Nome: "+clientes.get(i).getNome());
                System.out.println("Telefone: "+clientes.get(i).getTelefone());
                System.out.println("ID: "+clientes.get(i).getId());
            }
            else if(i==clientes.size()-1){
                System.out.println("Cliente não encontrado!");
            }
        }
    }

    public void alterarCliente(String nome, String telefone, int id){
        for(int i=0; i<clientes.size(); i++){
            if(clientes.get(i).getNome().equals(nome)){
                clientes.get(i).setNome(nome);
                clientes.get(i).setTelefone(telefone);
                clientes.get(i).setId(id);
            }
        }
    }

    public void listarClientes(){
        for(int i=0; i<clientes.size(); i++){
            System.out.println("Nome: "+clientes.get(i).getNome());
            System.out.println("Telefone: "+clientes.get(i).getTelefone());
            System.out.println("ID: "+clientes.get(i).getId());
        }
    }

    
}
