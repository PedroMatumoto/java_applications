

public class Aluno {
    private String nome;
    private float T1;
    private float T2;
    private float T3;
    private float T4;
    private float P1;
    private float P2;
    private int faltas;
    private String ultimaModificacao;

    public Aluno() {
        clearObject();
    }

    public Aluno(String nome, float T1, float T2, float T3, float T4, float P1, float P2, int faltas, String ultimaModificacao) {
        this.nome = nome;
        this.T1 = T1;
        this.T2 = T2;
        this.T3 = T3;
        this.T4 = T4;
        this.P1 = P1;
        this.P2 = P2;
        this.faltas = faltas;
        this.ultimaModificacao = ultimaModificacao;
    }

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

    public float getT1() {
        return T1;
    }

    public void setT1(float T1) {
        if (T1 >= 0 && T1 <= 10) {
            this.T1 = T1;
        } else {
            this.T1 = -1;
        }
    }

    public float getT2() {
        return T2;
    }

    public void setT2(float T2) {
        if (T2 >= 0 && T2 <= 10) {
            this.T2 = T2;
        } else {
            this.T2 = -1;
        }
    }

    public float getT3() {
        return T3;
    }

    public void setT3(float T3) {
        if (T3 >= 0 && T3 <= 10) {
            this.T3 = T3;
        } else {
            this.T3 = -1;
        }
    }

    public float getT4() {
        return T4;
    }

    public void setT4(float T4) {
        if (T4 >= 0 && T4 <= 10) {
            this.T4 = T4;
        } else {
            this.T4 = -1;
        }
    }

    public float getP1() {
        return P1;
    }

    public void setP1(float P1) {
        if (P1 >= 0 && P1 <= 10) {
            this.P1 = P1;
        } else {
            this.P1 = -1;
        }
    }

    public float getP2() {
        return P2;
    }

    public void setP2(float P2) {
        if (P2 >= 0 && P2 <= 10) {
            this.P2 = P2;
        } else {
            this.P2 = -1;
        }
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int faltas) {
        if (faltas >= 0 && faltas <= 100) {
            this.faltas = faltas;
        } else {
            this.faltas = -1;
        }
    }

    public String getUltimaModificacao() {
        return ultimaModificacao;
    }

    private void setUltimaModificacao(String ultimaModificacao) {
        this.ultimaModificacao = ultimaModificacao;
    }

    public void clearObject() {
        this.nome = "";
        this.T1 = -1;
        this.T2 = -1;
        this.T3 = -1;
        this.T4 = -1;
        this.P1 = -1;
        this.P2 = -1;
        this.faltas = -1;
    }

    @Override

    public String toString() {
        return "Aluno [nome=" + nome + ", T1=" + T1 + ", T2=" + T2 + ", T3=" + T3 + ", T4=" + T4 + ", P1=" + P1
                + ", P2=" + P2 + ", faltas=" + faltas + "]";
    }

    
}
