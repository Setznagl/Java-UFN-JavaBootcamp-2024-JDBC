package Jdbc.services;
import Jdbc.daos.DAO_ator;
import Jdbc.daos.DAO_categoria;

public class DAO_Factory {
    public static DAO_ator create_DAO_ator(){
        return new DAO_ator();
    }
    public static DAO_categoria create_DAO_categoria() {return new DAO_categoria();}
}
