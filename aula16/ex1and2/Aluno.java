package aula16.ex1and2;

public class Aluno {
    private String RA;
    private String nome;
    private String sobrenome;
    private double media;
    private String P1;
    private String P2;
    private String P3;
    private String P4;


    public Aluno(String RA, String nome, String sobrenome, double media, String P1, String P2, String P3, String P4) {
        this.RA = RA;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.media = media;
        this.P1 = P1;
        this.P2 = P2;
        this.P3 = P3;
        this.P4 = P4;

        
    }

    public Aluno(){
        this.RA = "";
        this.nome = "";
        this.sobrenome = "";
        this.media = 0;
        this.P1 = "";
        this.P2 = "";
        this.P3 = "";
        this.P4 = "";
    }  

    public String getRA() {
        return this.RA;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public double getMedia() {
        return this.media;
    }

    public String getP1() {
        return this.P1;
    }

    public String getP2() {
        return this.P2;
    }

    public String getP3() {
        return this.P3;
    }

    public String getP4() {
        return this.P4;
    }


    public void setRA(String RA) {
        this.RA = RA;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public void setP1(String P1) {
        this.P1 = P1;
    }

    public void setP2(String P2) {
        this.P2 = P2;
    }

    public void setP3(String P3) {
        this.P3 = P3;
    }

    public void setP4(String P4) {
        this.P4 = P4;
    }

    

    
}
