package Jdbc.models;

public class ator {
    private int cod_ator;
    private String nome;

    public ator() {
    }

    public ator(int cod_ator, String nome) {
        this.cod_ator = cod_ator;
        this.nome = nome;
    }

    // Getters
    public int getCod_ator() {
        return cod_ator;
    }

    public String getNome() {
        return nome;
    }

    // Setters
    public void setCod_ator(int parametro) {
        this.cod_ator = parametro;
    }

    public void setNome(String parametro) {
        this.nome = parametro;
    }

    @Override
    public String toString() {
        return "ator: " + "cod_ator:  " + cod_ator + ", nome:  " + nome + "\n";
    }

}
