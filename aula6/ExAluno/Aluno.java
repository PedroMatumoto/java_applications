package aula6.ExAluno;

import javax.swing.JOptionPane;

public class Aluno {

        private String nome;
        private int idade;
        private double peso;
        private boolean formando;
        private char sexo;

        public Aluno(String name, int age, double weight, char sex) {
            this.nome = name;
            this.idade = age;
            this.peso = weight;
            this.sexo = sex;
            this.formando = false;
        }
        public String getNome(){
            return nome;
        }
        
        public int getIdade() {
            return idade;
        }
        
        public double getPeso() {
            return peso;
        }
        public boolean getFormando(){
            return formando;
        }

        public char getSexo() {
            return sexo;
        }

        //Modificadores

        public void setSexo(char sex){
            sexo = sex;
        }

        public void setNome(String name){
            nome = name;
        }

        public void setIdade(int age){
            idade=age;
        }
        public void setPeso(double weight){
            peso=weight;
        }
        public void setFormando(boolean grader){
            formando=grader;
        }
    
}
