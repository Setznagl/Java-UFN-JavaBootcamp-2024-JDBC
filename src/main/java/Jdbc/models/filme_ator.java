package Jdbc.models;

public class filme_ator {
    private ator cod_ator;
    //private categoria cod_filme;
    private boolean ator;
    private boolean diretor;

        public filme_ator(){}
        public filme_ator(int cod_ator, int cod_filme, boolean ator, boolean diretor){
            //this.cod_ator = cod_ator;
            //this.cod_filme = cod_filme;
            this.ator = ator;
            this.diretor = diretor;
        }
}
