/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

public class Ocorrencia {
    private String nome;
    private String cpf;
    private String evento;
    private String data;
    private String cargaHoraria;
   
    public Ocorrencia() {
        clearObject();
    }
    
    public Ocorrencia(String nome, String cpf, String evento, String data, String cargaHoraria) {
        this.nome = nome;
        this.cpf = cpf;
        this.evento = evento;
        this.data = data;
        this.cargaHoraria = cargaHoraria;
    }
    
    ///
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome.length() > 0) {
            this.nome = nome;
        } else {
            this.nome = "Nome inválido";
        }
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        if (cpf.length() > 0) {
            this.cpf = cpf;
        } else {
            this.cpf = "CPF inválido";
        }
    }
    public String getEvento() {
        return evento;
    }
    public void setEvento(String evento) {
        if (evento.length() > 0) {
            this.evento = evento;
        } else {
            this.evento = "Evento inválido";
        }
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        if (data.length() > 0) {
            this.data = data;
        } else {
            this.data = "Data inválida";
        }
    }
    public String getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(String cargaHoraria) {
        if (cargaHoraria.length() > 0) {
            this.cargaHoraria = cargaHoraria;
        } else {
            this.cargaHoraria = "Carga horária inválida";
        }
    }
    ///
    
    @Override
    public String toString() {
        return ">> Ocorrencia: \nNome = " + nome + " \nCPF = " + cpf + " \nEvento = " + evento + " \nData = " + data + " \nCarga horaria = " + cargaHoraria;
    }
    
    public void clearObject() {
        this.nome = "Vazio";
        this.cpf = "Vazio";
        this.evento = "Vazio";
        this.data = "Vazio";
        this.cargaHoraria = "Vazio";
    }
}
