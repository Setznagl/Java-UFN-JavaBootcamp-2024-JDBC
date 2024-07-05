package Jdbc.models;

public class categoria {
    private int cod_cat;
    private String nome;
    private float valor;

    public categoria() {
    }

    public categoria(int cod_cat, String nome, float valor) {
        this.cod_cat = cod_cat;
        this.nome = nome;
        this.valor = valor;
    }

    //Getters
    public int getCod_cat() {
        return cod_cat;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    //Setters
    public void setCod_cat(int parametro) {
        cod_cat = parametro;
    }

    public void setNome(String parametro) {
        nome = parametro;
    }

    public void setValor(float parametro) {
        valor = parametro;
    }

    @Override
    public String toString() {
        return "Categoria: " + "cod_cat: "
                + cod_cat + ", nome: " + nome + "  valor: " + valor + "\n";
    }
}
