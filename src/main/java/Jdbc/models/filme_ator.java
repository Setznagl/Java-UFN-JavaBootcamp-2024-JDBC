package Jdbc.models;

public class filme_ator {
    private int cod_ator;
    private int cod_cat;
    private boolean ator;
    private boolean diretor;

        public filme_ator(){}
        public filme_ator(int cod_ator, int cod_filme, boolean ator, boolean diretor){
            this.cod_ator = cod_ator;
            //this.cod_filme = cod_filme;
            this.ator = ator;
            this.diretor = diretor;
        }
}
