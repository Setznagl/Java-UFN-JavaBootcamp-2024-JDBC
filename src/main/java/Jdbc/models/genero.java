package Jdbc.models;

public class genero {
    private int cod_gen;
    private String nome;

    public genero() {
    }

    public genero(int cod_gen, String nome) {
        this.cod_gen = cod_gen;
        this.nome = nome;
    }

    //Getters
    public int getCod_gen() {
        return cod_gen;
    }

    public String getNome() {
        return nome;
    }

    //Setters
    public void setCod_gen(int cod_gen) {
        this.cod_gen = cod_gen;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "genero: " + "cod_gen: " + cod_gen + ", nome: " + nome + "\n";
    }
}
